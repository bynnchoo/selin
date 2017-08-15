package com.selin.store.warehouse.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_warehouse <br/>
 *         描述：仓库表 <br/>
 */
public class WarehouseVo extends Warehouse {

	private List<WarehouseVo> warehouseList;

	public WarehouseVo() {
		super();
	}

	public WarehouseVo(Long id) {
		super();
		this.id = id;
	}

	public List<WarehouseVo> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WarehouseVo> warehouseList) {
		this.warehouseList = warehouseList;
	}

}
