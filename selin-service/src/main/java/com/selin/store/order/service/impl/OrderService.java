package com.selin.store.order.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.roof.commons.RoofDateUtils;
import org.roof.roof.dataaccess.api.Page;
import org.roof.web.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.selin.core.exception.SelinException;
import com.selin.store.customerprominimum.service.api.ICustomerProMinimumService;
import com.selin.store.dispatchorder.entity.DispatchStatusEnum;
import com.selin.store.invoice.entity.Invoice;
import com.selin.store.invoice.entity.InvoiceVo;
import com.selin.store.invoice.service.api.IInvoiceService;
import com.selin.store.norms.entity.ProductNorms;
import com.selin.store.norms.entity.ProductNormsVo;
import com.selin.store.norms.service.api.IProductNormsService;
import com.selin.store.order.dao.api.IOrderDao;
import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderPrintPros;
import com.selin.store.order.entity.OrderPrintVo;
import com.selin.store.order.entity.OrderVo;
import com.selin.store.order.service.api.IOrderService;
import com.selin.store.orderevent.entity.OrderEnum;
import com.selin.store.orderevent.entity.OrderEvent;
import com.selin.store.orderevent.entity.OrderEventEnum;
import com.selin.store.orderevent.entity.OrderEventVo;
import com.selin.store.orderevent.entity.OrderStatusEnum;
import com.selin.store.orderevent.entity.PayStatusEnum;
import com.selin.store.orderevent.service.api.IOrderEventService;
import com.selin.store.orderpros.entity.OrderPros;
import com.selin.store.orderpros.entity.OrderProsVo;
import com.selin.store.orderpros.service.api.IOrderProsService;
import com.selin.store.printconfig.entity.PrintConfig;
import com.selin.store.printconfig.entity.PrintConfigVo;
import com.selin.store.printconfig.entity.PrintTypeEnum;
import com.selin.store.printconfig.service.api.IPrintConfigService;
import com.selin.store.receiveaddress.entity.ReceiveAddress;
import com.selin.store.receiveaddress.entity.ReceiveAddressVo;
import com.selin.store.receiveaddress.service.api.IReceiveAddressService;
import com.selin.store.user.entity.Customer;
import com.selin.store.user.entity.SelinUser;
import com.selin.store.user.service.api.ICustomerService;
import com.selin.store.user.service.api.ISelinUserService;

@Service
public class OrderService implements IOrderService {

	private Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

	private IOrderDao orderDao;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private ISelinUserService selinUserService;

	@Autowired
	private IOrderProsService orderProsService;

	@Autowired
	private IOrderEventService orderEventService;

	@Autowired
	private IReceiveAddressService receiveAddressService;

	@Autowired
	private IInvoiceService invoiceService;

	@Autowired
	private ICustomerProMinimumService customerProMinimumService;

	@Autowired
	private IProductNormsService productNormsService;

	@Autowired
	private IPrintConfigService printConfigService;

	@SuppressWarnings("rawtypes")
	private RedisTemplate redisTemplate;

	public Page selectOrderPageForSale(Page page, OrderVo orderVo) {
		return orderDao.selectOrderPageForSale(page, orderVo);
	}

	public OrderVo selectOrderDetailForSale(Page page, OrderVo orderVo) {
		// 订单信息
		Order order = new Order();
		order.setId(orderVo.getId());
		OrderVo vo = this.load(order);
		// 订单商品信息
		List<OrderProsVo> proList = orderProsService.selectForListByOrderNum(vo.getOrder_num());
		vo.setProList(proList);
		// 收货信息
		ReceiveAddress receiveAddress = new ReceiveAddress();
		receiveAddress.setId(vo.getReceive_address_id());
		ReceiveAddressVo receiveAddressVo = receiveAddressService.load(receiveAddress);
		vo.setAddress(receiveAddressVo);
		// 附件信息 TODO

		// 操作日志
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setOrder_num(vo.getOrder_num());
		List<OrderEventVo> eventList = orderEventService.selectForList(orderEvent);
		vo.setEventList(eventList);
		// 发票信息
		Invoice invoice = new Invoice();
		invoice.setId(vo.getInvoice_id());
		InvoiceVo invoiceVo = invoiceService.load(invoice);
		vo.setInvoice(invoiceVo);
		// 客户
		Customer customer = customerService.load(vo.getCus_id());
		vo.setCus(customer);
		return vo;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Order orderAddBySales(OrderVo orderVo, User user) throws Exception {
		// 创建订单
		Order o = this.orderAdd(orderVo, user);
		// 自动审核通过
		orderVo.setId(o.getId());
		orderVo.setOrder_num(o.getOrder_num());
		o = this.orderConfirm(orderVo, user);
		return o;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Order orderAdd(OrderVo orderVo, User user) throws Exception {
		// 客户不能为空
		if (orderVo.getCus_id() == null) {
			throw new SelinException("客户不能为空");
		}
		// 商品清单不能为空
		if (orderVo.getPros() == null && orderVo.getPros().size() == 0) {
			throw new SelinException("商品清单不能为空");
		}
		Customer c = customerService.load(orderVo.getCus_id());
		String orderNum = createOrderCode(OrderEnum.order, new Date());
		orderVo.setOrder_num(orderNum);

		// 入库产品关联
		BigDecimal count = new BigDecimal(0);
		for (OrderPros pros : orderVo.getPros()) {
			pros.setOrder_num(orderNum);
			orderProsService.save(pros);
			count = count.add(new BigDecimal(pros.getPrice()).multiply(new BigDecimal(pros.getNum())));
		}
		// 入库事件
		OrderEvent event = null;
		try {
			event = (OrderEvent) orderEventService.onOrderEvent(orderVo, OrderEventEnum.orderAdd, user);
		} catch (Exception e) {
			LOGGER.error("订货单：" + orderVo.getOrder_num() + "事件操作失败", e);
			throw new SelinException("订货单：" + orderVo.getOrder_num() + "事件操作失败");
		}
		// 保存订单
		Order o = new Order();
		BeanUtils.copyProperties(orderVo, o);
		o.setOrder_num(orderNum);// 订单号
		o.setCreate_date(new Date());// 下单时间
		// o.setCus_id(c.getId());
		// o.setCus_num(c.getCus_num());// 客户编码
		o.setCus_name(c.getName());// 客户名称
		o.setCurrent_status(OrderStatusEnum.waitConfirm.getCode());// 订单当前状态
		o.setCurrent_event(event.getEvent_code());// 订单当前事件
		o.setAmount(count.toString());// 总金额
		o.setDispatch_status(DispatchStatusEnum.waitDispatch.getCode());
		o.setPay_status(PayStatusEnum.nopay.getCode());
		orderDao.save(o);
		// 关联附件更新 TODO

		return o;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Order orderConfirm(OrderVo orderVo, User user) {
		// 订货单号不能为空
		if (orderVo.getId() == null) {
			throw new SelinException("订货单号不能为空");
		}
		Order o = orderDao.load(Order.class, orderVo.getId());
		if (o == null) {
			throw new SelinException("订货单不存在");
		}
		if (!o.getCurrent_status().equals(OrderStatusEnum.waitConfirm.getCode())) {
			throw new SelinException("订货单号状态不为待订货单审核，无法审核订货单");
		}
		// 商品清单不能为空
		if (orderVo.getPros() == null && orderVo.getPros().size() == 0) {
			throw new SelinException("商品清单不能为空");
		}
		// 发送订单修改事件
		try {
			orderEventService.onOrderEvent(orderVo, OrderEventEnum.orderUpdate, user);
		} catch (Exception e) {
			LOGGER.error("订货单：" + orderVo.getOrder_num() + "事件操作失败", e);
			throw new SelinException("订货单：" + orderVo.getOrder_num() + "事件操作失败");
		}
		// 审核事件
		OrderEvent event = null;
		try {
			event = (OrderEvent) orderEventService.onOrderEvent(orderVo, OrderEventEnum.orderConfirm, user);
		} catch (Exception e) {
			LOGGER.error("订货单：" + orderVo.getOrder_num() + "事件操作失败", e);
			throw new SelinException("订货单：" + orderVo.getOrder_num() + "事件操作失败", e.getMessage());
		}

		// 修改订单状态
		Order oldOrder = new Order();
		BeanUtils.copyProperties(orderVo, oldOrder);
		oldOrder.setCurrent_status(OrderStatusEnum.waitDispatchConfirm.getCode());// 当前状态
		oldOrder.setCurrent_event(event.getEvent_code());// 当前事件
		this.updateIgnoreNull(oldOrder);
		// 关联附件更新 TODO

		// 设置客户针对性定价
		customerProMinimumService.saveCustomerProMinByOrder(orderVo.getPros(), oldOrder.getCus_id());

		return oldOrder;
	}

	public OrderVo orderFinanceConfirm(String orderNum, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVo dispatchConfirm(String orderNum, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVo back(String orderNum, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVo cancel(String orderNum, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String createOrderCode(OrderEnum eventEnum, Date date) {
		String key = eventEnum.getCodePrefix() + "-" + RoofDateUtils.dateToString(date, "yyyyMMdd");
		BoundValueOperations<String, Long> operations = redisTemplate.boundValueOps(key);// .increment(1);
		Long l = operations.increment(1);
		operations.expire(2, TimeUnit.DAYS);
		// int i = new SecureRandom().nextInt();
		String s = "00000" + l;
		s = s.substring(s.length() - 6, s.length());
		String str = key + "-" + s;
		return str;
	}

	public Serializable save(Order order) {
		return orderDao.save(order);
	}

	public void delete(Order order) {
		orderDao.delete(order);
	}

	public void deleteByExample(Order order) {
		orderDao.deleteByExample(order);
	}

	public void update(Order order) {
		orderDao.update(order);
	}

	public void updateIgnoreNull(Order order) {
		orderDao.updateIgnoreNull(order);
	}

	public void updateByExample(Order order) {
		orderDao.update("updateByExampleOrder", order);
	}

	public OrderVo load(Order order) {
		return (OrderVo) orderDao.reload(order);
	}

	public OrderVo selectForObject(Order order) {
		return (OrderVo) orderDao.selectForObject("selectOrder", order);
	}

	@SuppressWarnings("unchecked")
	public List<OrderVo> selectForList(Order order) {
		return (List<OrderVo>) orderDao.selectForList("selectOrder", order);
	}

	public Page page(Page page, Order order) {
		return orderDao.page(page, order);
	}

	@Autowired
	public void setIOrderDao(@Qualifier("orderDao") IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@SuppressWarnings("rawtypes")
	@Autowired
	public void setRedisTemplate(@Qualifier("redisTemplate") RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public OrderVo loadOrderByOrderNum(String orderNum) {
		Order o = new Order();
		o.setOrder_num(orderNum);
		List<OrderVo> ordervos = this.selectForList(o);
		if (ordervos != null) {
			return ordervos.get(0);
		}
		return null;
	}

	@Override
	public OrderPrintVo printOrderAuto(String orderNum) {
		OrderPrintVo print = this.printOrder(orderNum);
		SelinUser suser = selinUserService.load(print.getSale_id());
		// 根据订单创建人的门店位置选择消息频道->发送打印消息
		if (print.getSale_id() != null) {
			PrintConfig pc = new PrintConfig();
			pc.setOrg_id(suser.getOrg().getId());
			pc.setPrint_type(PrintTypeEnum.orderPrint.getCode());
			List<PrintConfigVo> pcs = printConfigService.selectForList(pc);
			for (PrintConfigVo printConfigVo : pcs) {
				redisTemplate.convertAndSend(printConfigVo.getChannel(), JSON.toJSONString(print));
			}
		}
		return print;
	}

	@Override
	public OrderPrintVo printOrder(String orderNum) {
		// 取订货单信息
		OrderVo order = this.loadOrderByOrderNum(orderNum);
		// 订单商品信息
		List<OrderProsVo> proList = orderProsService.selectForListByOrderNum(orderNum);
		List<OrderPrintPros> printPros = new ArrayList<OrderPrintPros>();
		for (OrderProsVo pro : proList) {
			OrderPrintPros printpro = new OrderPrintPros();
			printpro.setNum(pro.getNum());
			printpro.setPrice(pro.getPrice());
			printpro.setPro_name(pro.getPro_name());
			printpro.setPro_code(pro.getPro_code());
			ProductNormsVo norm = productNormsService.load(new ProductNorms(pro.getPro_norms_id()));
			printpro.setPro_norms_name("颜色:" + norm.getColour() + ",尺码:" + norm.getSize());
			printpro.setRemark(pro.getRemark());
			printpro.setUnit("件");
			printpro.setAmount(new BigDecimal(pro.getNum()).multiply(new BigDecimal(pro.getPrice())).doubleValue());
			printPros.add(printpro);
		}
		// 加载收货人信息
		ReceiveAddressVo receiveAddressVo = receiveAddressService
				.load(new ReceiveAddress(order.getReceive_address_id()));
		// 拼装订单打印信息
		OrderPrintVo print = new OrderPrintVo();

		print.setAmount(order.getAmount());
		print.setCreate_date(
				RoofDateUtils.dateToString(order.getCreate_date(), RoofDateUtils.DATE_TIME_EXPRESSION_GENERAL));
		print.setCus_name(order.getCus_name());
		if (order.getEx_date() != null) {
			print.setEx_date(
					RoofDateUtils.dateToString(order.getEx_date(), RoofDateUtils.DATE_TIME_EXPRESSION_GENERAL));
		}
		print.setNumCount(Long.valueOf(proList.size()));
		print.setOrder_num(order.getOrder_num());
		print.setPros(printPros);
		if (receiveAddressVo != null) {
			print.setAddress(receiveAddressVo.getAddress());
			print.setReceive_name(receiveAddressVo.getReceive_name());
			print.setTel(receiveAddressVo.getTel());
		}
		print.setSale_id(order.getSale_id());
		return print;
	}

}
