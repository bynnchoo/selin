package com.selin.store.invevent.entity;

import com.selin.store.inveventdetail.entity.InventoryEventProDetail;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_inventory_event <br/>
 *         描述：库存事件表 <br/>
 */
public class InventoryEventVo extends InventoryEvent {

	private List<InventoryEventVo> inventoryEventList;

	private List<InventoryEventProDetail> details;

	public InventoryEventVo() {
		super();
	}

	public InventoryEventVo(Long id) {
		super();
		this.id = id;
	}

	public List<InventoryEventVo> getInventoryEventList() {
		return inventoryEventList;
	}

	public void setInventoryEventList(List<InventoryEventVo> inventoryEventList) {
		this.inventoryEventList = inventoryEventList;
	}

	public void setDetails(List<InventoryEventProDetail> details) {
		this.details = details;
	}

	public List<InventoryEventProDetail> getDetails() {
		return details;
	}
}
