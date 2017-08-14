package com.selin.store.buyorderpros.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.buyorderpros.dao.api.IBuyOrderProsDao;
import com.selin.store.buyorderpros.entity.BuyOrderPros;
import com.selin.store.buyorderpros.entity.BuyOrderProsVo;
import com.selin.store.buyorderpros.service.api.IBuyOrderProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BuyOrderProsService implements IBuyOrderProsService {
	private IBuyOrderProsDao buyOrderProsDao;

	public Serializable save(BuyOrderPros buyOrderPros){
		return buyOrderProsDao.save(buyOrderPros);
	}

	public void delete(BuyOrderPros buyOrderPros){
		buyOrderProsDao.delete(buyOrderPros);
	}
	
	public void deleteByExample(BuyOrderPros buyOrderPros){
		buyOrderProsDao.deleteByExample(buyOrderPros);
	}

	public void update(BuyOrderPros buyOrderPros){
		buyOrderProsDao.update(buyOrderPros);
	}
	
	public void updateIgnoreNull(BuyOrderPros buyOrderPros){
		buyOrderProsDao.updateIgnoreNull(buyOrderPros);
	}
		
	public void updateByExample(BuyOrderPros buyOrderPros){
		buyOrderProsDao.update("updateByExampleBuyOrderPros", buyOrderPros);
	}

	public BuyOrderProsVo load(BuyOrderPros buyOrderPros){
		return (BuyOrderProsVo)buyOrderProsDao.reload(buyOrderPros);
	}
	
	public BuyOrderProsVo selectForObject(BuyOrderPros buyOrderPros){
		return (BuyOrderProsVo)buyOrderProsDao.selectForObject("selectBuyOrderPros",buyOrderPros);
	}
	
	public List<BuyOrderProsVo> selectForList(BuyOrderPros buyOrderPros){
		return (List<BuyOrderProsVo>)buyOrderProsDao.selectForList("selectBuyOrderPros",buyOrderPros);
	}
	
	public Page page(Page page, BuyOrderPros buyOrderPros) {
		return buyOrderProsDao.page(page, buyOrderPros);
	}

	@Autowired
	public void setIBuyOrderProsDao(
			@Qualifier("buyOrderProsDao") IBuyOrderProsDao  buyOrderProsDao) {
		this.buyOrderProsDao = buyOrderProsDao;
	}
	

}
