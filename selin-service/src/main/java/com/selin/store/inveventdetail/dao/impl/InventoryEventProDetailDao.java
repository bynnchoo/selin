package com.selin.store.inveventdetail.dao.impl;

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

import com.selin.store.inveventdetail.dao.api.IInventoryEventProDetailDao;
import com.selin.store.inveventdetail.entity.InventoryEventProDetail;
@Service
public class InventoryEventProDetailDao extends AbstractDao implements IInventoryEventProDetailDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, InventoryEventProDetail inventoryEventProDetail) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectInventoryEventProDetailPage", "selectInventoryEventProDetailCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectInventoryEventProDetailPage", null);
		return pageQuery.select(inventoryEventProDetail);
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