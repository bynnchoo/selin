package com.selin.store.orderevent.entity;

/**
 * 订货单状态
 * 
 * @author liht
 *
 */
public enum OrderStatusEnum {
	waitConfirm("waitConfirm", "待订货单审核"), watiFinanceConfirm("watiFinanceConfirm", "待财务审核"), waitDispatchConfirm(
			"waitDispatchConfirm", "待财务审核"), complete("complete", "已完成"), cancel("cancel", "已作废");

	private String code;

	private String name;

	OrderStatusEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
