package com.selin.store.orderevent.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.orderevent.entity.OrderEvent;

public interface IOrderEventDao extends IDaoSupport {
	Page page(Page page, OrderEvent orderEvent);
}