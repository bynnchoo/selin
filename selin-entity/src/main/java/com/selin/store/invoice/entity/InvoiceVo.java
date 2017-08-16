package com.selin.store.invoice.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_invoice <br/>
 *         描述：w_invoice <br/>
 */
public class InvoiceVo extends Invoice {

	private List<InvoiceVo> invoiceList;

	public InvoiceVo() {
		super();
	}

	public InvoiceVo(Long id) {
		super();
		this.id = id;
	}

	public List<InvoiceVo> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<InvoiceVo> invoiceList) {
		this.invoiceList = invoiceList;
	}

}
