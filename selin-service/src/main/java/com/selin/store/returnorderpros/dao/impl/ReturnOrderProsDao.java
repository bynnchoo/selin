package com.selin.store.returnorderpros.dao.impl;

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

import com.selin.store.returnorderpros.dao.api.IReturnOrderProsDao;
import com.selin.store.returnorderpros.entity.ReturnOrderPros;
@Service
public class ReturnOrderProsDao extends AbstractDao implements IReturnOrderProsDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, ReturnOrderPros returnOrderPros) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectReturnOrderProsPage", "selectReturnOrderProsCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectReturnOrderProsPage", null);
		return pageQuery.select(returnOrderPros);
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