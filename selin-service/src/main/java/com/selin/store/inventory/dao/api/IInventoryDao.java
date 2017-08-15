package com.selin.store.inventory.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.inventory.entity.Inventory;

public interface IInventoryDao extends IDaoSupport {
	Page page(Page page, Inventory inventory);

    Integer setStock(Long id, Integer newNum, Integer num);
}