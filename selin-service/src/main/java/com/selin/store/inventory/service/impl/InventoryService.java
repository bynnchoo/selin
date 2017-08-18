package com.selin.store.inventory.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selin.core.exception.SelinException;
import com.selin.store.invevent.service.api.IInventoryEventService;
import com.selin.store.inveventhis.entity.InventoryEventHis;
import com.selin.store.inveventhis.service.api.IInventoryEventHisService;
import com.selin.store.warehouse.entity.Warehouse;
import com.selin.store.warehouse.service.api.IWarehouseService;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.inventory.dao.api.IInventoryDao;
import com.selin.store.inventory.entity.Inventory;
import com.selin.store.inventory.entity.InventoryVo;
import com.selin.store.inventory.service.api.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {
	private IInventoryDao inventoryDao;


	private IWarehouseService warehouseService;

	private IInventoryEventService inventoryEventService;

	private IInventoryEventHisService inventoryEventHisService;

	public Serializable save(Inventory inventory){
		return inventoryDao.save(inventory);
	}

	public void delete(Inventory inventory){
		inventoryDao.delete(inventory);
	}
	
	public void deleteByExample(Inventory inventory){
		inventoryDao.deleteByExample(inventory);
	}

	public void update(Inventory inventory){
		inventoryDao.update(inventory);
	}
	
	public void updateIgnoreNull(Inventory inventory){
		inventoryDao.updateIgnoreNull(inventory);
	}
		
	public void updateByExample(Inventory inventory){
		inventoryDao.update("updateByExampleInventory", inventory);
	}

	public InventoryVo load(Inventory inventory){
		return (InventoryVo)inventoryDao.reload(inventory);
	}
	
	public InventoryVo selectForObject(Inventory inventory){
		return (InventoryVo)inventoryDao.selectForObject("selectInventory",inventory);
	}
	
	public List<InventoryVo> selectForList(Inventory inventory){
		return (List<InventoryVo>)inventoryDao.selectForList("selectInventory",inventory);
	}
	
	public Page page(Page page, Inventory inventory) {
		return inventoryDao.page(page, inventory);
	}

	public Integer setStock(Long pro_norms_id, Long warehouse_id, Integer num) {
		Integer i = 3;
		Map<String,Object> map = new HashMap<String, Object>();
		Inventory inventory = new Inventory();
		inventory.setPro_norms_id(pro_norms_id);
		inventory.setWarehouse_id(warehouse_id);
		Inventory in = selectForObject(inventory);
		if (in == null){ //第一次插入
			firstSave(pro_norms_id,warehouse_id,num);
			return num;
		}else {
			Integer newNum = in.getNum() + num;
			do{
				Integer updateRow = inventoryDao.setStock(in.getId(),newNum,in.getNum());
				if(updateRow != 0){//更新成功
					break;
				}else {
					i --;
					if (i == 0){
						throw new SelinException("更改库存异常");
					}
				}
			}while (true);
			return newNum;
		}
	}



	public void firstSave(Long pro_norms_id, Long warehouse_id, Integer num) {
		Inventory inventory = new Inventory();
		Warehouse w = warehouseService.load(new Warehouse(warehouse_id));
		inventory.setNum(num);
		inventory.setWarehouse_code(w.getCode());
		save(inventory);
	}

		@Autowired
	public void setIInventoryDao(
			@Qualifier("inventoryDao") IInventoryDao  inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	

}
