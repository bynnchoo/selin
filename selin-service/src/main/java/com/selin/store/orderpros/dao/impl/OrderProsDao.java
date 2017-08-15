package com.selin.store.orderpros.dao.impl;

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

import com.selin.store.orderpros.dao.api.IOrderProsDao;
import com.selin.store.orderpros.entity.OrderPros;
@Service
public class OrderProsDao extends AbstractDao implements IOrderProsDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, OrderPros orderPros) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectOrderProsPage", "selectOrderProsCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectOrderProsPage", null);
		return pageQuery.select(orderPros);
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