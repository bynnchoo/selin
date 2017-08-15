package com.selin.store.dispatchorderpros.dao.impl;

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

import com.selin.store.dispatchorderpros.dao.api.IDispatchOrderProsDao;
import com.selin.store.dispatchorderpros.entity.DispatchOrderPros;
@Service
public class DispatchOrderProsDao extends AbstractDao implements IDispatchOrderProsDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, DispatchOrderPros dispatchOrderPros) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectDispatchOrderProsPage", "selectDispatchOrderProsCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectDispatchOrderProsPage", null);
		return pageQuery.select(dispatchOrderPros);
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