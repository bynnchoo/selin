package com.selin.store.orderevent.entity;

public enum PayStatusEnum {
	nopay("nopay", "未付款"), payed("payed", "已付款");

	private String code;

	private String name;

	PayStatusEnum(String code, String name) {
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
