package com.selin.store.customerprominimum.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.customerprominimum.entity.CustomerProMinimum;

public interface ICustomerProMinimumDao extends IDaoSupport {
	Page page(Page page, CustomerProMinimum customerProMinimum);
}