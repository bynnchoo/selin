package com.selin.store.orderpros.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.orderpros.entity.OrderPros;

public interface IOrderProsDao extends IDaoSupport {
	Page page(Page page, OrderPros orderPros);
}