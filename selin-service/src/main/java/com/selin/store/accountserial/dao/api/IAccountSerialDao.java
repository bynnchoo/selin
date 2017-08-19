package com.selin.store.accountserial.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.accountserial.entity.AccountSerial;

public interface IAccountSerialDao extends IDaoSupport {
	Page page(Page page, AccountSerial accountSerial);
}