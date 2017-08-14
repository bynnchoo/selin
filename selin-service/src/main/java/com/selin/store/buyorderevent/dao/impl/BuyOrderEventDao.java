package com.selin.store.buyorderevent.dao.impl;

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

import com.selin.store.buyorderevent.dao.api.IBuyOrderEventDao;
import com.selin.store.buyorderevent.entity.BuyOrderEvent;
@Service
public class BuyOrderEventDao extends AbstractDao implements IBuyOrderEventDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, BuyOrderEvent buyOrderEvent) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectBuyOrderEventPage", "selectBuyOrderEventCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectBuyOrderEventPage", null);
		return pageQuery.select(buyOrderEvent);
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