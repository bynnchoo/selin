package com.selin.store.brand.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.brand.entity.Brand;

public interface IBrandDao extends IDaoSupport {
	Page page(Page page, Brand brand);
}