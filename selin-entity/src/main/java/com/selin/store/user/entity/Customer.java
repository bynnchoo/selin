package com.selin.store.user.entity;

/**
 * Created by lenovo on 2017/8/17.
 */
public class Customer extends SelinUser {

	private Long default_address;

	public Long getDefault_address() {
		return default_address;
	}

	public void setDefault_address(Long default_address) {
		this.default_address = default_address;
	}

}