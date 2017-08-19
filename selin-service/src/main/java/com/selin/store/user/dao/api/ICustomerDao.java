package com.selin.store.user.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;

import com.selin.store.user.entity.Customer;

/**
 * Created by lenovo on 2017/8/17.
 */
public interface ICustomerDao extends IDaoSupport {
	void save(Customer user);
}
