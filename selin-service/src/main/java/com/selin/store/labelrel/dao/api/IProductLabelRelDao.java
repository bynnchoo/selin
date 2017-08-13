package com.selin.store.labelrel.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.labelrel.entity.ProductLabelRel;

public interface IProductLabelRelDao extends IDaoSupport {
	Page page(Page page, ProductLabelRel productLabelRel);
}