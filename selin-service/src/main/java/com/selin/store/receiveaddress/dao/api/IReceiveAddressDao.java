package com.selin.store.receiveaddress.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.receiveaddress.entity.ReceiveAddress;

public interface IReceiveAddressDao extends IDaoSupport {
	Page page(Page page, ReceiveAddress receiveAddress);
}