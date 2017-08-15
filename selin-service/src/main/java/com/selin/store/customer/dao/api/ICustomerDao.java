package com.selin.store.customer.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.customer.entity.Customer;

public interface ICustomerDao extends IDaoSupport {
	Page page(Page page, Customer customer);
}