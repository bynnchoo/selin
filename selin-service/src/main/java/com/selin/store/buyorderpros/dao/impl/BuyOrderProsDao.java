package com.selin.store.buyorderpros.dao.impl;

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

import com.selin.store.buyorderpros.dao.api.IBuyOrderProsDao;
import com.selin.store.buyorderpros.entity.BuyOrderPros;
@Service
public class BuyOrderProsDao extends AbstractDao implements IBuyOrderProsDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, BuyOrderPros buyOrderPros) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectBuyOrderProsPage", "selectBuyOrderProsCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectBuyOrderProsPage", null);
		return pageQuery.select(buyOrderPros);
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