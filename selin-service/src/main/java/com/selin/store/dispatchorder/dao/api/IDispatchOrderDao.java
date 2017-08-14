package com.selin.store.dispatchorder.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.dispatchorder.entity.DispatchOrder;

public interface IDispatchOrderDao extends IDaoSupport {
	Page page(Page page, DispatchOrder dispatchOrder);
}