package com.selin.store.supplier.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.supplier.entity.Supplier;

public interface ISupplierDao extends IDaoSupport {
	Page page(Page page, Supplier supplier);
}