package com.selin.store.buyorderpros.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.buyorderpros.entity.BuyOrderPros;

public interface IBuyOrderProsDao extends IDaoSupport {
	Page page(Page page, BuyOrderPros buyOrderPros);
}