package com.selin.store.buyorderevent.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.buyorderevent.entity.BuyOrderEvent;

public interface IBuyOrderEventDao extends IDaoSupport {
	Page page(Page page, BuyOrderEvent buyOrderEvent);
}