package com.selin.store.receiveaddress.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.receiveaddress.dao.api.IReceiveAddressDao;
import com.selin.store.receiveaddress.entity.ReceiveAddress;
import com.selin.store.receiveaddress.entity.ReceiveAddressVo;
import com.selin.store.receiveaddress.service.api.IReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReceiveAddressService implements IReceiveAddressService {
	private IReceiveAddressDao receiveAddressDao;

	public Serializable save(ReceiveAddress receiveAddress){
		return receiveAddressDao.save(receiveAddress);
	}

	public void delete(ReceiveAddress receiveAddress){
		receiveAddressDao.delete(receiveAddress);
	}
	
	public void deleteByExample(ReceiveAddress receiveAddress){
		receiveAddressDao.deleteByExample(receiveAddress);
	}

	public void update(ReceiveAddress receiveAddress){
		receiveAddressDao.update(receiveAddress);
	}
	
	public void updateIgnoreNull(ReceiveAddress receiveAddress){
		receiveAddressDao.updateIgnoreNull(receiveAddress);
	}
		
	public void updateByExample(ReceiveAddress receiveAddress){
		receiveAddressDao.update("updateByExampleReceiveAddress", receiveAddress);
	}

	public ReceiveAddressVo load(ReceiveAddress receiveAddress){
		return (ReceiveAddressVo)receiveAddressDao.reload(receiveAddress);
	}
	
	public ReceiveAddressVo selectForObject(ReceiveAddress receiveAddress){
		return (ReceiveAddressVo)receiveAddressDao.selectForObject("selectReceiveAddress",receiveAddress);
	}
	
	public List<ReceiveAddressVo> selectForList(ReceiveAddress receiveAddress){
		return (List<ReceiveAddressVo>)receiveAddressDao.selectForList("selectReceiveAddress",receiveAddress);
	}
	
	public Page page(Page page, ReceiveAddress receiveAddress) {
		return receiveAddressDao.page(page, receiveAddress);
	}

	@Autowired
	public void setIReceiveAddressDao(
			@Qualifier("receiveAddressDao") IReceiveAddressDao  receiveAddressDao) {
		this.receiveAddressDao = receiveAddressDao;
	}
	

}
