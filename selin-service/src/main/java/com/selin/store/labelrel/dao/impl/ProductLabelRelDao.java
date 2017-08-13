package com.selin.store.labelrel.dao.impl;

import java.util.Comparator;
import java.util.HashMap;

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

import com.selin.store.labelrel.dao.api.IProductLabelRelDao;
import com.selin.store.labelrel.entity.ProductLabelRel;
@Service
public class ProductLabelRelDao extends AbstractDao implements IProductLabelRelDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, ProductLabelRel productLabelRel) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectProductLabelRelPage", "selectProductLabelRelCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectProductLabelRelPage", null);
		return pageQuery.select(productLabelRel);
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