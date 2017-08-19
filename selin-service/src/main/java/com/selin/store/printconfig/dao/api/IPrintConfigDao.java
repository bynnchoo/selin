package com.selin.store.printconfig.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.printconfig.entity.PrintConfig;

public interface IPrintConfigDao extends IDaoSupport {
	Page page(Page page, PrintConfig printConfig);
}