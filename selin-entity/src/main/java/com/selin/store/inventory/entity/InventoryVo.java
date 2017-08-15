package com.selin.store.inventory.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_inventory <br/>
 *         描述：库存信息表 <br/>
 */
public class InventoryVo extends Inventory {

	private List<InventoryVo> inventoryList;

	public InventoryVo() {
		super();
	}

	public InventoryVo(Long id) {
		super();
		this.id = id;
	}

	public List<InventoryVo> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<InventoryVo> inventoryList) {
		this.inventoryList = inventoryList;
	}

}
