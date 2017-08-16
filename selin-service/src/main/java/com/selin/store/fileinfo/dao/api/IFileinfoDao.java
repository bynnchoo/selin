package com.selin.store.fileinfo.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.fileinfo.entity.Fileinfo;

public interface IFileinfoDao extends IDaoSupport {
	Page page(Page page, Fileinfo fileinfo);
}