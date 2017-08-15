package com.selin.store.warehouse.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.warehouse.entity.Warehouse;

public interface IWarehouseDao extends IDaoSupport {
	Page page(Page page, Warehouse warehouse);
}