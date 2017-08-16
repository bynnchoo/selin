package com.selin.store.orderevent.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.roof.commons.RoofDateUtils;
import org.roof.roof.dataaccess.api.Page;
import org.roof.web.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderVo;
import com.selin.store.order.service.api.IOrderService;
import com.selin.store.orderevent.dao.api.IOrderEventDao;
import com.selin.store.orderevent.entity.OrderEnum;
import com.selin.store.orderevent.entity.OrderEvent;
import com.selin.store.orderevent.entity.OrderEventEnum;
import com.selin.store.orderevent.entity.OrderEventVo;
import com.selin.store.orderevent.service.api.IOrderEventService;
import com.selin.store.orderpros.entity.OrderPros;
import com.selin.store.orderpros.entity.OrderProsVo;
import com.selin.store.orderpros.service.api.IOrderProsService;

@Service
public class OrderEventService implements IOrderEventService {
	private IOrderEventDao orderEventDao;

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private IOrderProsService orderProsService;

	@Autowired
	private IOrderService orderService;

	@Override
	public String createEventCode(OrderEventEnum eventEnum, Date date) throws Exception {
		String key = eventEnum.getCodePrefix() + "-" + RoofDateUtils.dateToString(date, "yyyyMMddhh");
		BoundValueOperations<String, Long> operations = redisTemplate.boundValueOps(key);// .increment(1);
		Long l = operations.increment(1);
		operations.expire(2, TimeUnit.DAYS);
		int i = new SecureRandom().nextInt();
		String s = "00000" + l;
		s = s.substring(s.length() - 6, s.length());
		String str = key + "-" + s;
		return str;
	}

	@Override
	public Object onOrderEvent(Object source, OrderEventEnum eventType, User user) throws Exception {
		// 保存事件日志
		Object returnObject = null;
		switch (eventType.getEventCode()) {
		case "orderAdd":
			Order order = (Order) source;
			OrderEvent event = saveOrderEvent(eventType, user, order, "已提交订货单，等待订货单审核");
			returnObject = event;
			break;
		case "orderConfirm":
			Order order1 = (Order) source;
			OrderEvent event1 = saveOrderEvent(eventType, user, order1, "已提交订货单，等待订货单审核");
			returnObject = event1;
			break;
		case "orderFinanceConfirm":

			break;
		case "dispatchConfirm":

			break;
		case "complete":

			break;
		case "cancel":

			break;
		case "back":

			break;
		case "orderUpdate":
			// 判断商品数量修改情况，更新订单商品信息，并返回订单总价
			OrderVo orderVo = (OrderVo) source;
			List<OrderPros> newPros = orderVo.getPros();
			List<OrderProsVo> oldPros = orderProsService.selectForListByOrderNum(orderVo.getOrder_num());
			BigDecimal amount = new BigDecimal(0);
			for (OrderProsVo oldp : oldPros) {
				for (OrderPros newp : newPros) {
					if (oldp.getPro_norms_id().longValue() == newp.getPro_norms_id().longValue()) {
						if (oldp.getPrice().doubleValue() != newp.getPrice().doubleValue()) {
							String remark = "商品名称:" + oldp.getPro_name() + "，原订货金额：￥" + oldp.getPrice() + "，修改后：￥"
									+ newp.getPrice();
							this.saveOrderEvent(eventType, user, orderVo, remark);
							newp.setId(oldp.getId());
							orderProsService.updateIgnoreNull(newp);
						}
						amount = amount.add(new BigDecimal(newp.getPrice()).multiply(new BigDecimal(newp.getNum())));
					}
				}
			}
			Order o = new Order();
			o.setId(orderVo.getId());
			o.setAmount(amount.toString());
			orderService.updateIgnoreNull(o);
			returnObject = amount;
			break;
		default:
			break;
		}
		return returnObject;
	}

	public OrderEvent saveOrderEvent(OrderEventEnum eventType, User user, Order order, String remark) throws Exception {
		OrderEvent event = new OrderEvent();
		event.setCreate_date(new Date());
		event.setCreate_user_id(user.getId());
		event.setEvent(eventType.getEventCode());//
		event.setEvent_code(this.createEventCode(eventType, new Date()));// 事件编码
		event.setEvent_type(OrderEnum.order.getCode());
		event.setOrder_num(order.getOrder_num());
		event.setEvent_name(eventType.getEventName());
		event.setReamrk(remark);
		this.save(event);
		return event;
	}

	public Serializable save(OrderEvent orderEvent) {
		return orderEventDao.save(orderEvent);
	}

	public void delete(OrderEvent orderEvent) {
		orderEventDao.delete(orderEvent);
	}

	public void deleteByExample(OrderEvent orderEvent) {
		orderEventDao.deleteByExample(orderEvent);
	}

	public void update(OrderEvent orderEvent) {
		orderEventDao.update(orderEvent);
	}

	public void updateIgnoreNull(OrderEvent orderEvent) {
		orderEventDao.updateIgnoreNull(orderEvent);
	}

	public void updateByExample(OrderEvent orderEvent) {
		orderEventDao.update("updateByExampleOrderEvent", orderEvent);
	}

	public OrderEventVo load(OrderEvent orderEvent) {
		return (OrderEventVo) orderEventDao.reload(orderEvent);
	}

	public OrderEventVo selectForObject(OrderEvent orderEvent) {
		return (OrderEventVo) orderEventDao.selectForObject("selectOrderEvent", orderEvent);
	}

	public List<OrderEventVo> selectForList(OrderEvent orderEvent) {
		return (List<OrderEventVo>) orderEventDao.selectForList("selectOrderEvent", orderEvent);
	}

	public Page page(Page page, OrderEvent orderEvent) {
		return orderEventDao.page(page, orderEvent);
	}

	@Autowired
	public void setIOrderEventDao(@Qualifier("orderEventDao") IOrderEventDao orderEventDao) {
		this.orderEventDao = orderEventDao;
	}

}
