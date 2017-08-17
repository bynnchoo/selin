package com.selin.store.customerprominimum.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_customer_pro_minimum <br/>
 *         描述：w_customer_pro_minimum <br/>
 */
public class CustomerProMinimumVo extends CustomerProMinimum {

	private List<CustomerProMinimumVo> customerProMinimumList;

	public CustomerProMinimumVo() {
		super();
	}

	public CustomerProMinimumVo(Long id) {
		super();
		this.id = id;
	}

	public List<CustomerProMinimumVo> getCustomerProMinimumList() {
		return customerProMinimumList;
	}

	public void setCustomerProMinimumList(List<CustomerProMinimumVo> customerProMinimumList) {
		this.customerProMinimumList = customerProMinimumList;
	}

}
