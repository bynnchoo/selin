package com.selin.store.warehouse.dao.impl;

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

import com.selin.store.warehouse.dao.api.IWarehouseDao;
import com.selin.store.warehouse.entity.Warehouse;
@Service
public class WarehouseDao extends AbstractDao implements IWarehouseDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, Warehouse warehouse) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectWarehousePage", "selectWarehouseCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectWarehousePage", null);
		return pageQuery.select(warehouse);
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