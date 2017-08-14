package com.selin.store.buyorder.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.buyorder.dao.api.IBuyOrderDao;
import com.selin.store.buyorder.entity.BuyOrder;
import com.selin.store.buyorder.entity.BuyOrderVo;
import com.selin.store.buyorder.service.api.IBuyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BuyOrderService implements IBuyOrderService {
	private IBuyOrderDao buyOrderDao;

	public Serializable save(BuyOrder buyOrder){
		return buyOrderDao.save(buyOrder);
	}

	public void delete(BuyOrder buyOrder){
		buyOrderDao.delete(buyOrder);
	}
	
	public void deleteByExample(BuyOrder buyOrder){
		buyOrderDao.deleteByExample(buyOrder);
	}

	public void update(BuyOrder buyOrder){
		buyOrderDao.update(buyOrder);
	}
	
	public void updateIgnoreNull(BuyOrder buyOrder){
		buyOrderDao.updateIgnoreNull(buyOrder);
	}
		
	public void updateByExample(BuyOrder buyOrder){
		buyOrderDao.update("updateByExampleBuyOrder", buyOrder);
	}

	public BuyOrderVo load(BuyOrder buyOrder){
		return (BuyOrderVo)buyOrderDao.reload(buyOrder);
	}
	
	public BuyOrderVo selectForObject(BuyOrder buyOrder){
		return (BuyOrderVo)buyOrderDao.selectForObject("selectBuyOrder",buyOrder);
	}
	
	public List<BuyOrderVo> selectForList(BuyOrder buyOrder){
		return (List<BuyOrderVo>)buyOrderDao.selectForList("selectBuyOrder",buyOrder);
	}
	
	public Page page(Page page, BuyOrder buyOrder) {
		return buyOrderDao.page(page, buyOrder);
	}

	@Autowired
	public void setIBuyOrderDao(
			@Qualifier("buyOrderDao") IBuyOrderDao  buyOrderDao) {
		this.buyOrderDao = buyOrderDao;
	}
	

}
