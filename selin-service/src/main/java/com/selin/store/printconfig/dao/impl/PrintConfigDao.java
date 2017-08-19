package com.selin.store.printconfig.dao.impl;

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

import com.selin.store.printconfig.dao.api.IPrintConfigDao;
import com.selin.store.printconfig.entity.PrintConfig;
@Service
public class PrintConfigDao extends AbstractDao implements IPrintConfigDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, PrintConfig printConfig) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectPrintConfigPage", "selectPrintConfigCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectPrintConfigPage", null);
		return pageQuery.select(printConfig);
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