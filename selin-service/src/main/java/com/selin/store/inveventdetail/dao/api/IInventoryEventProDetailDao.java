package com.selin.store.inveventdetail.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.inveventdetail.entity.InventoryEventProDetail;

public interface IInventoryEventProDetailDao extends IDaoSupport {
	Page page(Page page, InventoryEventProDetail inventoryEventProDetail);
}