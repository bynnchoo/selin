package com.selin.store.orderevent.entity;

/**
 * 订货单事件类型
 * 
 * @author liht
 *
 */
public enum OrderEventEnum {

	orderAdd(OrderEnum.order, "orderAdd", "新增订货单"), orderConfirm(OrderEnum.order, "orderConfirm",
			"订货单确认"), orderFinanceConfirm(OrderEnum.order, "orderFinanceConfirm", "财务确认"), dispatchConfirm(
					OrderEnum.order, "dispatchConfirm", "发货确认"), complete(OrderEnum.order, "complete",
							"完成"), cancel(OrderEnum.order, "cancel", "取消"), back(OrderEnum.order, "back", "退回");

	private OrderEnum orderType;// order类型

	private String eventCode;// 事件编码

	private String eventName;// 事件名称

	OrderEventEnum(OrderEnum orderType, String eventCode, String eventName) {
		this.orderType = orderType;
		this.eventCode = eventCode;
		this.eventName = eventName;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public OrderEnum getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderEnum orderType) {
		this.orderType = orderType;
	}

}
