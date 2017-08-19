package com.selin.store.accountserial.dao.impl;

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

import com.selin.store.accountserial.dao.api.IAccountSerialDao;
import com.selin.store.accountserial.entity.AccountSerial;
@Service
public class AccountSerialDao extends AbstractDao implements IAccountSerialDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, AccountSerial accountSerial) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectAccountSerialPage", "selectAccountSerialCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectAccountSerialPage", null);
		return pageQuery.select(accountSerial);
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