package com.selin.store.returnorderpros.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.returnorderpros.entity.ReturnOrderPros;

public interface IReturnOrderProsDao extends IDaoSupport {
	Page page(Page page, ReturnOrderPros returnOrderPros);
}