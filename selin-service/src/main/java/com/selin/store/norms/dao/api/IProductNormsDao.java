package com.selin.store.norms.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.norms.entity.ProductNorms;

public interface IProductNormsDao extends IDaoSupport {
	Page page(Page page, ProductNorms productNorms);
}