package com.selin.store.dispatchorder.entity;

public enum DispatchStatusEnum {
	waitDispatch("waitDispatch", "备货中/待发货"), dispatched("dispatched", "已出库/已发货");

	private String code;
	private String name;

	DispatchStatusEnum(String code, String name) {
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
