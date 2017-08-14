package com.selin.store.dispatchorder.dao.impl;

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

import com.selin.store.dispatchorder.dao.api.IDispatchOrderDao;
import com.selin.store.dispatchorder.entity.DispatchOrder;
@Service
public class DispatchOrderDao extends AbstractDao implements IDispatchOrderDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, DispatchOrder dispatchOrder) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectDispatchOrderPage", "selectDispatchOrderCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectDispatchOrderPage", null);
		return pageQuery.select(dispatchOrder);
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