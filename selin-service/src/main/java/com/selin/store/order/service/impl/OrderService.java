package com.selin.store.order.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.selin.core.exception.SelinException;
import com.selin.store.customer.dao.api.ICustomerDao;
import com.selin.store.customer.entity.Customer;
import com.selin.store.order.dao.api.IOrderDao;
import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderVo;
import com.selin.store.order.service.api.IOrderService;
import com.selin.store.orderevent.entity.OrderEnum;
import com.selin.store.orderevent.entity.OrderEvent;
import com.selin.store.orderevent.entity.OrderEventEnum;
import com.selin.store.orderevent.entity.OrderStatusEnum;
import com.selin.store.orderevent.service.api.IOrderEventService;
import com.selin.store.orderpros.entity.OrderPros;
import com.selin.store.orderpros.service.api.IOrderProsService;

@Service
public class OrderService implements IOrderService {

	private Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

	private IOrderDao orderDao;

	@Autowired
	private ICustomerDao customerDao;

	@Autowired
	private IOrderProsService orderProsService;

	@Autowired
	private IOrderEventService orderEventService;

	@SuppressWarnings("rawtypes")
	private RedisTemplate redisTemplate;

	public Order orderAddBySales(OrderVo orderVo, User user) throws Exception {
		// 创建订单
		Order o = this.orderAdd(orderVo, user);
		// 自动审核通过
		orderVo.setId(o.getId());
		orderVo.setOrder_num(o.getOrder_num());
		o = this.orderConfirm(orderVo, user);
		return o;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Order orderAdd(OrderVo orderVo, User user) throws Exception {
		// 客户不能为空
		if (orderVo.getCus_id() == null) {
			throw new SelinException("客户不能为空");
		}
		// 商品清单不能为空
		if (orderVo.getPros() == null && orderVo.getPros().size() == 0) {
			throw new SelinException("商品清单不能为空");
		}
		// 客户收货地址
		// if (orderVo.getAddress() == null && orderVo.getAddress().getId() ==
		// null) {
		//
		// }
		Customer c = customerDao.load(Customer.class, orderVo.getCus_id());
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
		o.setCus_num(c.getCus_num());// 客户编码
		o.setCus_name(c.getCus_name());// 客户名称
		o.setCurrent_status(OrderStatusEnum.waitConfirm.getCode());// 订单当前状态
		o.setCurrent_event(event.getEvent_code());// 订单当前事件
		o.setAmount(count.toString());// 总金额
		orderDao.save(o);
		// 关联附件更新 TODO

		return o;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Order orderConfirm(OrderVo orderVo, User user) {
		// 订货单号不能为空
		if (orderVo.getId() == null) {
			throw new SelinException("订货单号不能为空");
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
		// Order oldOrder = orderDao.load(Order.class, orderVo.getId());
		Order oldOrder = new Order();
		BeanUtils.copyProperties(orderVo, oldOrder);
		oldOrder.setCurrent_status(OrderStatusEnum.waitDispatchConfirm.getCode());// 当前状态
		oldOrder.setCurrent_event(event.getEvent_code());// 当前事件
		this.updateIgnoreNull(oldOrder);
		// 关联附件更新 TODO

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
		String key = eventEnum.getCodePrefix() + "-" + RoofDateUtils.dateToString(date, "yyyyMMddhh");
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

}
