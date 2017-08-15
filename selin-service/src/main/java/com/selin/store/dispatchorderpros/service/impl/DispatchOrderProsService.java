package com.selin.store.dispatchorderpros.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.dispatchorderpros.dao.api.IDispatchOrderProsDao;
import com.selin.store.dispatchorderpros.entity.DispatchOrderPros;
import com.selin.store.dispatchorderpros.entity.DispatchOrderProsVo;
import com.selin.store.dispatchorderpros.service.api.IDispatchOrderProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DispatchOrderProsService implements IDispatchOrderProsService {
	private IDispatchOrderProsDao dispatchOrderProsDao;

	public Serializable save(DispatchOrderPros dispatchOrderPros){
		return dispatchOrderProsDao.save(dispatchOrderPros);
	}

	public void delete(DispatchOrderPros dispatchOrderPros){
		dispatchOrderProsDao.delete(dispatchOrderPros);
	}
	
	public void deleteByExample(DispatchOrderPros dispatchOrderPros){
		dispatchOrderProsDao.deleteByExample(dispatchOrderPros);
	}

	public void update(DispatchOrderPros dispatchOrderPros){
		dispatchOrderProsDao.update(dispatchOrderPros);
	}
	
	public void updateIgnoreNull(DispatchOrderPros dispatchOrderPros){
		dispatchOrderProsDao.updateIgnoreNull(dispatchOrderPros);
	}
		
	public void updateByExample(DispatchOrderPros dispatchOrderPros){
		dispatchOrderProsDao.update("updateByExampleDispatchOrderPros", dispatchOrderPros);
	}

	public DispatchOrderProsVo load(DispatchOrderPros dispatchOrderPros){
		return (DispatchOrderProsVo)dispatchOrderProsDao.reload(dispatchOrderPros);
	}
	
	public DispatchOrderProsVo selectForObject(DispatchOrderPros dispatchOrderPros){
		return (DispatchOrderProsVo)dispatchOrderProsDao.selectForObject("selectDispatchOrderPros",dispatchOrderPros);
	}
	
	public List<DispatchOrderProsVo> selectForList(DispatchOrderPros dispatchOrderPros){
		return (List<DispatchOrderProsVo>)dispatchOrderProsDao.selectForList("selectDispatchOrderPros",dispatchOrderPros);
	}
	
	public Page page(Page page, DispatchOrderPros dispatchOrderPros) {
		return dispatchOrderProsDao.page(page, dispatchOrderPros);
	}

	@Autowired
	public void setIDispatchOrderProsDao(
			@Qualifier("dispatchOrderProsDao") IDispatchOrderProsDao  dispatchOrderProsDao) {
		this.dispatchOrderProsDao = dispatchOrderProsDao;
	}
	

}
