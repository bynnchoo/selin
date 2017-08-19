package com.selin.store.accountserial.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.accountserial.dao.api.IAccountSerialDao;
import com.selin.store.accountserial.entity.AccountSerial;
import com.selin.store.accountserial.entity.AccountSerialVo;
import com.selin.store.accountserial.service.api.IAccountSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccountSerialService implements IAccountSerialService {
	private IAccountSerialDao accountSerialDao;

	public Serializable save(AccountSerial accountSerial){
		return accountSerialDao.save(accountSerial);
	}

	public void delete(AccountSerial accountSerial){
		accountSerialDao.delete(accountSerial);
	}
	
	public void deleteByExample(AccountSerial accountSerial){
		accountSerialDao.deleteByExample(accountSerial);
	}

	public void update(AccountSerial accountSerial){
		accountSerialDao.update(accountSerial);
	}
	
	public void updateIgnoreNull(AccountSerial accountSerial){
		accountSerialDao.updateIgnoreNull(accountSerial);
	}
		
	public void updateByExample(AccountSerial accountSerial){
		accountSerialDao.update("updateByExampleAccountSerial", accountSerial);
	}

	public AccountSerialVo load(AccountSerial accountSerial){
		return (AccountSerialVo)accountSerialDao.reload(accountSerial);
	}
	
	public AccountSerialVo selectForObject(AccountSerial accountSerial){
		return (AccountSerialVo)accountSerialDao.selectForObject("selectAccountSerial",accountSerial);
	}
	
	public List<AccountSerialVo> selectForList(AccountSerial accountSerial){
		return (List<AccountSerialVo>)accountSerialDao.selectForList("selectAccountSerial",accountSerial);
	}
	
	public Page page(Page page, AccountSerial accountSerial) {
		return accountSerialDao.page(page, accountSerial);
	}

	@Autowired
	public void setIAccountSerialDao(
			@Qualifier("accountSerialDao") IAccountSerialDao  accountSerialDao) {
		this.accountSerialDao = accountSerialDao;
	}
	

}
