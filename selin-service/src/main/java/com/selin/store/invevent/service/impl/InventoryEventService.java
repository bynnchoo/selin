package com.selin.store.invevent.service.impl;

import java.io.Serializable;
import java.util.List;

import com.selin.store.inventory.service.api.IInventoryService;
import com.selin.store.invevent.entity.InventoryEventEnum;
import com.selin.store.inveventdetail.entity.InventoryEventProDetail;
import com.selin.store.inveventdetail.service.api.IInventoryEventProDetailService;
import com.selin.store.inveventhis.entity.InventoryEventHis;
import com.selin.store.inveventhis.service.api.IInventoryEventHisService;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.invevent.dao.api.IInventoryEventDao;
import com.selin.store.invevent.entity.InventoryEvent;
import com.selin.store.invevent.entity.InventoryEventVo;
import com.selin.store.invevent.service.api.IInventoryEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InventoryEventService implements IInventoryEventService {
	private IInventoryEventDao inventoryEventDao;

	private IInventoryService inventoryService;

	private IInventoryEventHisService inventoryEventHisService;

	private IInventoryEventProDetailService inventoryEventProDetailService;

	public Serializable save(InventoryEvent inventoryEvent){
		return inventoryEventDao.save(inventoryEvent);
	}

	public void delete(InventoryEvent inventoryEvent){
		inventoryEventDao.delete(inventoryEvent);
	}
	
	public void deleteByExample(InventoryEvent inventoryEvent){
		inventoryEventDao.deleteByExample(inventoryEvent);
	}

	public void update(InventoryEvent inventoryEvent){
		inventoryEventDao.update(inventoryEvent);
	}
	
	public void updateIgnoreNull(InventoryEvent inventoryEvent){
		inventoryEventDao.updateIgnoreNull(inventoryEvent);
	}
		
	public void updateByExample(InventoryEvent inventoryEvent){
		inventoryEventDao.update("updateByExampleInventoryEvent", inventoryEvent);
	}

	public InventoryEventVo load(InventoryEvent inventoryEvent){
		return (InventoryEventVo)inventoryEventDao.reload(inventoryEvent);
	}
	
	public InventoryEventVo selectForObject(InventoryEvent inventoryEvent){
		return (InventoryEventVo)inventoryEventDao.selectForObject("selectInventoryEvent",inventoryEvent);
	}
	
	public List<InventoryEventVo> selectForList(InventoryEvent inventoryEvent){
		return (List<InventoryEventVo>)inventoryEventDao.selectForList("selectInventoryEvent",inventoryEvent);
	}
	
	public Page page(Page page, InventoryEvent inventoryEvent) {
		return inventoryEventDao.page(page, inventoryEvent);
	}

	public void inStock(InventoryEventVo vo) {
		//1.根据不同的入库类型生成不同的入库事件
		//2.插入事件明细表
		//3.循环修改库存setStock();
		String eventType =  vo.getEvent_type();
		InventoryEventEnum eventEnum =  InventoryEventEnum.valueOf(eventType);
		switch (eventEnum){
			case IN_PROCUREMENT:
				inventoryEventHisService.procurement_in(vo.getIn_warehouse_id(),vo.getIn_date(),vo.getCreate_user_id(),null,null);
				break;
			case IN_ALLOT:
				inventoryEventHisService.allot_in(vo.getIn_warehouse_id(),vo.getIn_date(),vo.getCreate_user_id(),null,null);
				break;
		}
		for (InventoryEventProDetail detail :vo.getDetails()){
			inventoryEventProDetailService.save(detail);
			inventoryService.setStock(detail.getNorm_id(),vo.getIn_warehouse_id(),detail.getNum());
		}
	}

	@Autowired
	public void setIInventoryEventDao(
			@Qualifier("inventoryEventDao") IInventoryEventDao  inventoryEventDao) {
		this.inventoryEventDao = inventoryEventDao;
	}
	

}
