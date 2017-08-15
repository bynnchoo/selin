package com.selin.store.orderevent.dao.impl;

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

import com.selin.store.orderevent.dao.api.IOrderEventDao;
import com.selin.store.orderevent.entity.OrderEvent;
@Service
public class OrderEventDao extends AbstractDao implements IOrderEventDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, OrderEvent orderEvent) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectOrderEventPage", "selectOrderEventCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectOrderEventPage", null);
		return pageQuery.select(orderEvent);
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