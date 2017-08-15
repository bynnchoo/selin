package com.selin.store.receiveaddress.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_receive_address <br/>
 *         描述：收货地址表 <br/>
 */
public class ReceiveAddressVo extends ReceiveAddress {

	private List<ReceiveAddressVo> receiveAddressList;

	public ReceiveAddressVo() {
		super();
	}

	public ReceiveAddressVo(Long id) {
		super();
		this.id = id;
	}

	public List<ReceiveAddressVo> getReceiveAddressList() {
		return receiveAddressList;
	}

	public void setReceiveAddressList(List<ReceiveAddressVo> receiveAddressList) {
		this.receiveAddressList = receiveAddressList;
	}

}
