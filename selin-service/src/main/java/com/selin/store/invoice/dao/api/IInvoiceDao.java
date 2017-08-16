package com.selin.store.invoice.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.invoice.entity.Invoice;

public interface IInvoiceDao extends IDaoSupport {
	Page page(Page page, Invoice invoice);
}