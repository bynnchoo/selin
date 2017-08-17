package com.selin.store.receiveaddress.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_receive_address <br/>
 *         描述：收货地址表 <br/>
 */
public class ReceiveAddressVo extends ReceiveAddress {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2816788968842527035L;
	private List<ReceiveAddressVo> receiveAddressList;

	private String area_name;

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

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	@Override
	public String toString() {
		return "ReceiveAddressVo [receiveAddressList=" + receiveAddressList + ", area_name=" + area_name + "]";
	}

}
