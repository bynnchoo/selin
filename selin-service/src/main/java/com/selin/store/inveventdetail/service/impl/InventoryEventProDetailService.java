package com.selin.store.inveventdetail.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.inveventdetail.dao.api.IInventoryEventProDetailDao;
import com.selin.store.inveventdetail.entity.InventoryEventProDetail;
import com.selin.store.inveventdetail.entity.InventoryEventProDetailVo;
import com.selin.store.inveventdetail.service.api.IInventoryEventProDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InventoryEventProDetailService implements IInventoryEventProDetailService {
	private IInventoryEventProDetailDao inventoryEventProDetailDao;

	public Serializable save(InventoryEventProDetail inventoryEventProDetail){
		return inventoryEventProDetailDao.save(inventoryEventProDetail);
	}

	public void delete(InventoryEventProDetail inventoryEventProDetail){
		inventoryEventProDetailDao.delete(inventoryEventProDetail);
	}
	
	public void deleteByExample(InventoryEventProDetail inventoryEventProDetail){
		inventoryEventProDetailDao.deleteByExample(inventoryEventProDetail);
	}

	public void update(InventoryEventProDetail inventoryEventProDetail){
		inventoryEventProDetailDao.update(inventoryEventProDetail);
	}
	
	public void updateIgnoreNull(InventoryEventProDetail inventoryEventProDetail){
		inventoryEventProDetailDao.updateIgnoreNull(inventoryEventProDetail);
	}
		
	public void updateByExample(InventoryEventProDetail inventoryEventProDetail){
		inventoryEventProDetailDao.update("updateByExampleInventoryEventProDetail", inventoryEventProDetail);
	}

	public InventoryEventProDetailVo load(InventoryEventProDetail inventoryEventProDetail){
		return (InventoryEventProDetailVo)inventoryEventProDetailDao.reload(inventoryEventProDetail);
	}
	
	public InventoryEventProDetailVo selectForObject(InventoryEventProDetail inventoryEventProDetail){
		return (InventoryEventProDetailVo)inventoryEventProDetailDao.selectForObject("selectInventoryEventProDetail",inventoryEventProDetail);
	}
	
	public List<InventoryEventProDetailVo> selectForList(InventoryEventProDetail inventoryEventProDetail){
		return (List<InventoryEventProDetailVo>)inventoryEventProDetailDao.selectForList("selectInventoryEventProDetail",inventoryEventProDetail);
	}
	
	public Page page(Page page, InventoryEventProDetail inventoryEventProDetail) {
		return inventoryEventProDetailDao.page(page, inventoryEventProDetail);
	}

	@Override
	public Serializable saveList(List<InventoryEventProDetail> inventoryEventProDetails) {
		for (InventoryEventProDetail detail:inventoryEventProDetails) {
			save(detail);
		}
		return null;
	}

	@Autowired
	public void setIInventoryEventProDetailDao(
			@Qualifier("inventoryEventProDetailDao") IInventoryEventProDetailDao  inventoryEventProDetailDao) {
		this.inventoryEventProDetailDao = inventoryEventProDetailDao;
	}
	

}
