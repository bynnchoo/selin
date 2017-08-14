package com.selin.store.dispatchorder.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.dispatchorder.dao.api.IDispatchOrderDao;
import com.selin.store.dispatchorder.entity.DispatchOrder;
import com.selin.store.dispatchorder.entity.DispatchOrderVo;
import com.selin.store.dispatchorder.service.api.IDispatchOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DispatchOrderService implements IDispatchOrderService {
	private IDispatchOrderDao dispatchOrderDao;

	public Serializable save(DispatchOrder dispatchOrder){
		return dispatchOrderDao.save(dispatchOrder);
	}

	public void delete(DispatchOrder dispatchOrder){
		dispatchOrderDao.delete(dispatchOrder);
	}
	
	public void deleteByExample(DispatchOrder dispatchOrder){
		dispatchOrderDao.deleteByExample(dispatchOrder);
	}

	public void update(DispatchOrder dispatchOrder){
		dispatchOrderDao.update(dispatchOrder);
	}
	
	public void updateIgnoreNull(DispatchOrder dispatchOrder){
		dispatchOrderDao.updateIgnoreNull(dispatchOrder);
	}
		
	public void updateByExample(DispatchOrder dispatchOrder){
		dispatchOrderDao.update("updateByExampleDispatchOrder", dispatchOrder);
	}

	public DispatchOrderVo load(DispatchOrder dispatchOrder){
		return (DispatchOrderVo)dispatchOrderDao.reload(dispatchOrder);
	}
	
	public DispatchOrderVo selectForObject(DispatchOrder dispatchOrder){
		return (DispatchOrderVo)dispatchOrderDao.selectForObject("selectDispatchOrder",dispatchOrder);
	}
	
	public List<DispatchOrderVo> selectForList(DispatchOrder dispatchOrder){
		return (List<DispatchOrderVo>)dispatchOrderDao.selectForList("selectDispatchOrder",dispatchOrder);
	}
	
	public Page page(Page page, DispatchOrder dispatchOrder) {
		return dispatchOrderDao.page(page, dispatchOrder);
	}

	@Autowired
	public void setIDispatchOrderDao(
			@Qualifier("dispatchOrderDao") IDispatchOrderDao  dispatchOrderDao) {
		this.dispatchOrderDao = dispatchOrderDao;
	}
	

}
