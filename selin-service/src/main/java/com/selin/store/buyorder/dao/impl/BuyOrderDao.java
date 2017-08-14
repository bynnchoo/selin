package com.selin.store.buyorder.dao.impl;

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

import com.selin.store.buyorder.dao.api.IBuyOrderDao;
import com.selin.store.buyorder.entity.BuyOrder;
@Service
public class BuyOrderDao extends AbstractDao implements IBuyOrderDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, BuyOrder buyOrder) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectBuyOrderPage", "selectBuyOrderCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectBuyOrderPage", null);
		return pageQuery.select(buyOrder);
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