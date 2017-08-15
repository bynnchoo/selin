package com.selin.store.warehouse.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.warehouse.dao.api.IWarehouseDao;
import com.selin.store.warehouse.entity.Warehouse;
import com.selin.store.warehouse.entity.WarehouseVo;
import com.selin.store.warehouse.service.api.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService implements IWarehouseService {
	private IWarehouseDao warehouseDao;

	public Serializable save(Warehouse warehouse){
		return warehouseDao.save(warehouse);
	}

	public void delete(Warehouse warehouse){
		warehouseDao.delete(warehouse);
	}
	
	public void deleteByExample(Warehouse warehouse){
		warehouseDao.deleteByExample(warehouse);
	}

	public void update(Warehouse warehouse){
		warehouseDao.update(warehouse);
	}
	
	public void updateIgnoreNull(Warehouse warehouse){
		warehouseDao.updateIgnoreNull(warehouse);
	}
		
	public void updateByExample(Warehouse warehouse){
		warehouseDao.update("updateByExampleWarehouse", warehouse);
	}

	public WarehouseVo load(Warehouse warehouse){
		return (WarehouseVo)warehouseDao.reload(warehouse);
	}
	
	public WarehouseVo selectForObject(Warehouse warehouse){
		return (WarehouseVo)warehouseDao.selectForObject("selectWarehouse",warehouse);
	}
	
	public List<WarehouseVo> selectForList(Warehouse warehouse){
		return (List<WarehouseVo>)warehouseDao.selectForList("selectWarehouse",warehouse);
	}
	
	public Page page(Page page, Warehouse warehouse) {
		return warehouseDao.page(page, warehouse);
	}

	@Autowired
	public void setIWarehouseDao(
			@Qualifier("warehouseDao") IWarehouseDao  warehouseDao) {
		this.warehouseDao = warehouseDao;
	}
	

}
