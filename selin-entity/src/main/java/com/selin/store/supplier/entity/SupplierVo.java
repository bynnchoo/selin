package com.selin.store.supplier.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_supplier <br/>
 *         描述：w_supplier <br/>
 */
public class SupplierVo extends Supplier {

	private List<SupplierVo> supplierList;

	public SupplierVo() {
		super();
	}

	public SupplierVo(Long id) {
		super();
		this.id = id;
	}

	public List<SupplierVo> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<SupplierVo> supplierList) {
		this.supplierList = supplierList;
	}

}
