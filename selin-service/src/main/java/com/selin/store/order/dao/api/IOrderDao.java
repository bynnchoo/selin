package com.selin.store.order.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderVo;

public interface IOrderDao extends IDaoSupport {
	Page page(Page page, Order order);

	Page selectOrderPageForSale(Page page, OrderVo orderVo);
}