package com.selin.store.productpic.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.productpic.entity.ProductPic;

public interface IProductPicDao extends IDaoSupport {
	Page page(Page page, ProductPic productPic);
}