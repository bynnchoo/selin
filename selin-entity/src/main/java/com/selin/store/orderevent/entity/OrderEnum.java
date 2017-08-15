package com.selin.store.orderevent.entity;

/**
 * 单据类型
 * 
 * @author liht
 *
 */
public enum OrderEnum {
	order("order", "订货单", "DH"), returnOrder("returnOrder", "退货单", "TH"), buyOrder("buyOrder", "采购单",
			"CG"), dispatchOrder("dispatchOrder", "发货单", "FH");

	private String code;

	private String name;

	private String codePrefix;

	OrderEnum(String code, String name, String codePrefix) {
		this.code = code;
		this.name = name;
		this.codePrefix = codePrefix;
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

	public String getCodePrefix() {
		return codePrefix;
	}

	public void setCodePrefix(String codePrefix) {
		this.codePrefix = codePrefix;
	}
}
