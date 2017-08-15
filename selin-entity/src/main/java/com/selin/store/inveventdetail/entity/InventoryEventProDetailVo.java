package com.selin.store.inveventdetail.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_inventory_event_pro_detail <br/>
 *         描述：仓库事件商品明细 <br/>
 */
public class InventoryEventProDetailVo extends InventoryEventProDetail {

	private List<InventoryEventProDetailVo> inventoryEventProDetailList;

	public InventoryEventProDetailVo() {
		super();
	}

	public InventoryEventProDetailVo(Long id) {
		super();
		this.id = id;
	}

	public List<InventoryEventProDetailVo> getInventoryEventProDetailList() {
		return inventoryEventProDetailList;
	}

	public void setInventoryEventProDetailList(List<InventoryEventProDetailVo> inventoryEventProDetailList) {
		this.inventoryEventProDetailList = inventoryEventProDetailList;
	}

}
