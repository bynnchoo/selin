package com.selin.store.returnorder.dao.impl;

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

import com.selin.store.returnorder.dao.api.IReturnOrderDao;
import com.selin.store.returnorder.entity.ReturnOrder;
@Service
public class ReturnOrderDao extends AbstractDao implements IReturnOrderDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, ReturnOrder returnOrder) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectReturnOrderPage", "selectReturnOrderCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectReturnOrderPage", null);
		return pageQuery.select(returnOrder);
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