package com.selin.store.returnorder.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.returnorder.dao.api.IReturnOrderDao;
import com.selin.store.returnorder.entity.ReturnOrder;
import com.selin.store.returnorder.entity.ReturnOrderVo;
import com.selin.store.returnorder.service.api.IReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReturnOrderService implements IReturnOrderService {
	private IReturnOrderDao returnOrderDao;

	public Serializable save(ReturnOrder returnOrder){
		return returnOrderDao.save(returnOrder);
	}

	public void delete(ReturnOrder returnOrder){
		returnOrderDao.delete(returnOrder);
	}
	
	public void deleteByExample(ReturnOrder returnOrder){
		returnOrderDao.deleteByExample(returnOrder);
	}

	public void update(ReturnOrder returnOrder){
		returnOrderDao.update(returnOrder);
	}
	
	public void updateIgnoreNull(ReturnOrder returnOrder){
		returnOrderDao.updateIgnoreNull(returnOrder);
	}
		
	public void updateByExample(ReturnOrder returnOrder){
		returnOrderDao.update("updateByExampleReturnOrder", returnOrder);
	}

	public ReturnOrderVo load(ReturnOrder returnOrder){
		return (ReturnOrderVo)returnOrderDao.reload(returnOrder);
	}
	
	public ReturnOrderVo selectForObject(ReturnOrder returnOrder){
		return (ReturnOrderVo)returnOrderDao.selectForObject("selectReturnOrder",returnOrder);
	}
	
	public List<ReturnOrderVo> selectForList(ReturnOrder returnOrder){
		return (List<ReturnOrderVo>)returnOrderDao.selectForList("selectReturnOrder",returnOrder);
	}
	
	public Page page(Page page, ReturnOrder returnOrder) {
		return returnOrderDao.page(page, returnOrder);
	}

	@Autowired
	public void setIReturnOrderDao(
			@Qualifier("returnOrderDao") IReturnOrderDao  returnOrderDao) {
		this.returnOrderDao = returnOrderDao;
	}
	

}
