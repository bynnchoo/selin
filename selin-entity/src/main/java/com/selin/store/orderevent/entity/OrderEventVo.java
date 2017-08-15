package com.selin.store.orderevent.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_order_event <br/>
 *         描述：订单事件表 <br/>
 */
public class OrderEventVo extends OrderEvent {

	private List<OrderEventVo> orderEventList;

	public OrderEventVo() {
		super();
	}

	public OrderEventVo(Long id) {
		super();
		this.id = id;
	}

	public List<OrderEventVo> getOrderEventList() {
		return orderEventList;
	}

	public void setOrderEventList(List<OrderEventVo> orderEventList) {
		this.orderEventList = orderEventList;
	}

}
