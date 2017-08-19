package com.selin.store.accountserial.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_account_serial <br/>
 *         描述：w_account_serial <br/>
 */
public class AccountSerialVo extends AccountSerial {

	private List<AccountSerialVo> accountSerialList;

	public AccountSerialVo() {
		super();
	}

	public AccountSerialVo(Long id) {
		super();
		this.id = id;
	}

	public List<AccountSerialVo> getAccountSerialList() {
		return accountSerialList;
	}

	public void setAccountSerialList(List<AccountSerialVo> accountSerialList) {
		this.accountSerialList = accountSerialList;
	}

}
