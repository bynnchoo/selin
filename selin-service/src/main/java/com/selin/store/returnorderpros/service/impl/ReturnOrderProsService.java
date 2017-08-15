package com.selin.store.returnorderpros.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.returnorderpros.dao.api.IReturnOrderProsDao;
import com.selin.store.returnorderpros.entity.ReturnOrderPros;
import com.selin.store.returnorderpros.entity.ReturnOrderProsVo;
import com.selin.store.returnorderpros.service.api.IReturnOrderProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReturnOrderProsService implements IReturnOrderProsService {
	private IReturnOrderProsDao returnOrderProsDao;

	public Serializable save(ReturnOrderPros returnOrderPros){
		return returnOrderProsDao.save(returnOrderPros);
	}

	public void delete(ReturnOrderPros returnOrderPros){
		returnOrderProsDao.delete(returnOrderPros);
	}
	
	public void deleteByExample(ReturnOrderPros returnOrderPros){
		returnOrderProsDao.deleteByExample(returnOrderPros);
	}

	public void update(ReturnOrderPros returnOrderPros){
		returnOrderProsDao.update(returnOrderPros);
	}
	
	public void updateIgnoreNull(ReturnOrderPros returnOrderPros){
		returnOrderProsDao.updateIgnoreNull(returnOrderPros);
	}
		
	public void updateByExample(ReturnOrderPros returnOrderPros){
		returnOrderProsDao.update("updateByExampleReturnOrderPros", returnOrderPros);
	}

	public ReturnOrderProsVo load(ReturnOrderPros returnOrderPros){
		return (ReturnOrderProsVo)returnOrderProsDao.reload(returnOrderPros);
	}
	
	public ReturnOrderProsVo selectForObject(ReturnOrderPros returnOrderPros){
		return (ReturnOrderProsVo)returnOrderProsDao.selectForObject("selectReturnOrderPros",returnOrderPros);
	}
	
	public List<ReturnOrderProsVo> selectForList(ReturnOrderPros returnOrderPros){
		return (List<ReturnOrderProsVo>)returnOrderProsDao.selectForList("selectReturnOrderPros",returnOrderPros);
	}
	
	public Page page(Page page, ReturnOrderPros returnOrderPros) {
		return returnOrderProsDao.page(page, returnOrderPros);
	}

	@Autowired
	public void setIReturnOrderProsDao(
			@Qualifier("returnOrderProsDao") IReturnOrderProsDao  returnOrderProsDao) {
		this.returnOrderProsDao = returnOrderProsDao;
	}
	

}
