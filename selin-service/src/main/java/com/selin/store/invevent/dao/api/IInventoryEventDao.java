package com.selin.store.invevent.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.invevent.entity.InventoryEvent;

public interface IInventoryEventDao extends IDaoSupport {
	Page page(Page page, InventoryEvent inventoryEvent);
}