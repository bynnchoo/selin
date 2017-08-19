package com.selin.store.printconfig.entity;

/**
 * 单据类型
 * 
 * @author liht
 *
 */
public enum PrintTypeEnum {
	orderPrint("orderPrint", "订货单");

	private String code;

	private String name;

	PrintTypeEnum(String code, String name) {
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
