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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(propagation = Propagation.REQUIRES_NEW ,rollbackFor=Exception.class)
	public void inStock(InventoryEventVo vo) {
		//1.根据不同的入库类型生成不同的入库事件
		//2.插入事件明细表
		//3.循环修改库存setStock();
		String event =  vo.getEvent();
		InventoryEventEnum eventEnum =  InventoryEventEnum.valueOf(event);
		switch (eventEnum.getType()){
			case "IN":
				inventoryEventHisService.in(vo.getIn_warehouse_id(),vo.getIn_date(),vo.getCreate_user_id(),eventEnum,vo.getEvent_code());
				break;
			case "OUT":
				inventoryEventHisService.out(vo.getIn_warehouse_id(),vo.getIn_date(),vo.getCreate_user_id(),eventEnum,vo.getEvent_code());
				break;
		}
		stock(vo);
	}

	private void stock(InventoryEventVo vo) {
		for (InventoryEventProDetail detail :vo.getDetails()){
			Integer his_num = inventoryService.setStock(detail.getNorm_id(),vo.getIn_warehouse_id(),detail.getNum());
			detail.setHis_num(his_num);
			detail.setEvent_code(vo.getEvent_code());
			inventoryEventProDetailService.save(detail);
		}
	}

	@Autowired
	public void setIInventoryEventDao(
			@Qualifier("inventoryEventDao") IInventoryEventDao  inventoryEventDao) {
		this.inventoryEventDao = inventoryEventDao;
	}
	@Autowired
	public void setInventoryEventHisService(@Qualifier("inventoryEventHisService")IInventoryEventHisService inventoryEventHisService) {
		this.inventoryEventHisService = inventoryEventHisService;
	}
	@Autowired
	public void setInventoryEventProDetailService(@Qualifier("inventoryEventProDetailService")IInventoryEventProDetailService inventoryEventProDetailService) {
		this.inventoryEventProDetailService = inventoryEventProDetailService;
	}
	@Autowired
	public void setInventoryService(@Qualifier("inventoryService")IInventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
}
