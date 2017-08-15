package com.selin.store.product.dao.api;

import com.selin.store.product.entity.ProductVo;
import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.product.entity.Product;

import java.util.List;

public interface IProductDao extends IDaoSupport {
	Page page(Page page, Product product);

	Page productNomrsPage(Page page, Product product);

	List<ProductVo> selectProductNormsList(Product product);

	Page productNomrsStockPage(Page page, Product product);
}