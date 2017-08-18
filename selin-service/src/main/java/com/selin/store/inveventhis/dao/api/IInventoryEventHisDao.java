package com.selin.store.inveventhis.dao.api;

import com.selin.store.inveventhis.entity.InventoryEventHisVo;
import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.inveventhis.entity.InventoryEventHis;

public interface IInventoryEventHisDao extends IDaoSupport {
	Page page(Page page, InventoryEventHisVo inventoryEventHis);

    Page detailPage(Page page, InventoryEventHisVo inventoryEventHis);

}