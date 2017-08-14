package com.selin.store.returnorder.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.returnorder.entity.ReturnOrder;

public interface IReturnOrderDao extends IDaoSupport {
	Page page(Page page, ReturnOrder returnOrder);
}