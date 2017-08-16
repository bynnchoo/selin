package com.selin.store.eventhandling;

import java.util.Date;
import java.util.EventObject;

import org.roof.spring.CurrentSpringContext;

import com.selin.store.order.entity.OrderVo;
import com.selin.store.orderevent.entity.OrderEnum;
import com.selin.store.orderevent.entity.OrderEvent;
import com.selin.store.orderevent.entity.OrderEventEnum;
import com.selin.store.orderevent.service.api.IOrderEventService;

public class OrderAddEvent extends EventObject implements CommonEvent {

	/* serialVersionUID */
	private static final long serialVersionUID = 5677392380693158499L;

	public OrderAddEvent(OrderVo source) {
		super(source);
	}

	@Override
	public void handler() {
		IOrderEventService orderEventService = (IOrderEventService) CurrentSpringContext.getBean("orderEventService");
		OrderVo orderVo = (OrderVo) source;
		System.out.println(orderVo.getId());
		// 保存事件日志
//		OrderEvent event = new OrderEvent();
//		event.setCreate_date(new Date());
//		event.setCreate_user_id(orderVo.getCurrentUser().getId());
//		event.setEvent(OrderEventEnum.orderAdd.getEventCode());//
//		event.setEvent_code(orderEventService.createEventCode(OrderEventEnum.orderAdd, new Date()));
//		event.setEvent_type(OrderEnum.order.getCode());
//		event.setOrder_num(orderVo.getOrder_num());
//		event.setReamrk(OrderEventEnum.orderAdd.getEventName());
//		orderEventService.save(event);

	}

}
