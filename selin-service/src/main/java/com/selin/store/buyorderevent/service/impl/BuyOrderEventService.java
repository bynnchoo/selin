package com.selin.store.buyorderevent.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.buyorderevent.dao.api.IBuyOrderEventDao;
import com.selin.store.buyorderevent.entity.BuyOrderEvent;
import com.selin.store.buyorderevent.entity.BuyOrderEventVo;
import com.selin.store.buyorderevent.service.api.IBuyOrderEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BuyOrderEventService implements IBuyOrderEventService {
	private IBuyOrderEventDao buyOrderEventDao;

	public Serializable save(BuyOrderEvent buyOrderEvent){
		return buyOrderEventDao.save(buyOrderEvent);
	}

	public void delete(BuyOrderEvent buyOrderEvent){
		buyOrderEventDao.delete(buyOrderEvent);
	}
	
	public void deleteByExample(BuyOrderEvent buyOrderEvent){
		buyOrderEventDao.deleteByExample(buyOrderEvent);
	}

	public void update(BuyOrderEvent buyOrderEvent){
		buyOrderEventDao.update(buyOrderEvent);
	}
	
	public void updateIgnoreNull(BuyOrderEvent buyOrderEvent){
		buyOrderEventDao.updateIgnoreNull(buyOrderEvent);
	}
		
	public void updateByExample(BuyOrderEvent buyOrderEvent){
		buyOrderEventDao.update("updateByExampleBuyOrderEvent", buyOrderEvent);
	}

	public BuyOrderEventVo load(BuyOrderEvent buyOrderEvent){
		return (BuyOrderEventVo)buyOrderEventDao.reload(buyOrderEvent);
	}
	
	public BuyOrderEventVo selectForObject(BuyOrderEvent buyOrderEvent){
		return (BuyOrderEventVo)buyOrderEventDao.selectForObject("selectBuyOrderEvent",buyOrderEvent);
	}
	
	public List<BuyOrderEventVo> selectForList(BuyOrderEvent buyOrderEvent){
		return (List<BuyOrderEventVo>)buyOrderEventDao.selectForList("selectBuyOrderEvent",buyOrderEvent);
	}
	
	public Page page(Page page, BuyOrderEvent buyOrderEvent) {
		return buyOrderEventDao.page(page, buyOrderEvent);
	}

	@Autowired
	public void setIBuyOrderEventDao(
			@Qualifier("buyOrderEventDao") IBuyOrderEventDao  buyOrderEventDao) {
		this.buyOrderEventDao = buyOrderEventDao;
	}
	

}
