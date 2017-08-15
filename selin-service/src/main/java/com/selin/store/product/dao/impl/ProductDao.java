package com.selin.store.product.dao.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.selin.store.product.entity.ProductVo;
import org.apache.commons.lang3.StringUtils;
import org.roof.dataaccess.PageQuery;
import org.roof.roof.dataaccess.api.AbstractDao;
import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.IPageQuery;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.selin.store.product.dao.api.IProductDao;
import com.selin.store.product.entity.Product;
@Service
public class ProductDao extends AbstractDao implements IProductDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, Product product) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectProductPage", "selectProductCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectProductPage", null);
		return pageQuery.select(product);
	}

	@Override
	public Page productNomrsPage(Page page, Product product) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectProductNormsPage_", "selectProductNormsCount_");
		return pageQuery.select(product);
	}

	@Override
	public List<ProductVo> selectProductNormsList(Product product) {
		return (List<ProductVo>) this.daoSupport.selectForList("selectProductNormsList",product);
	}

	@Override
	public Page productNomrsStockPage(Page page, Product product) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectProductNormsStockPage", "selectProductNormsStockCount");
		return pageQuery.select(product);
	}

	@Autowired
	public void setPageQueryFactory(
			@Qualifier("pageQueryFactory") PageQueryFactory<PageQuery> pageQueryFactory) {
		this.pageQueryFactory = pageQueryFactory;
	}
	
	@Autowired
	public void setDaoSupport(
			@Qualifier("roofDaoSupport") IDaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

}