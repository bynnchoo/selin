package com.selin.store.dispatchorderpros.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.dispatchorderpros.entity.DispatchOrderPros;

public interface IDispatchOrderProsDao extends IDaoSupport {
	Page page(Page page, DispatchOrderPros dispatchOrderPros);
}