package com.selin.store.inveventhis.entity;

import java.util.Date;
import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_inventory_event_his <br/>
 *         描述：w_inventory_event_his <br/>
 */
public class InventoryEventHisVo extends InventoryEventHis {

	private List<InventoryEventHisVo> inventoryEventHisList;

	private Date beginDate;
	private Date endDate;


	public InventoryEventHisVo() {
		super();
	}

	public InventoryEventHisVo(Long id) {
		super();
		this.id = id;
	}

	public List<InventoryEventHisVo> getInventoryEventHisList() {
		return inventoryEventHisList;
	}

	public void setInventoryEventHisList(List<InventoryEventHisVo> inventoryEventHisList) {
		this.inventoryEventHisList = inventoryEventHisList;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}
}
