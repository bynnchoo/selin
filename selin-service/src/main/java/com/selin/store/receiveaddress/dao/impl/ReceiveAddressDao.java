package com.selin.store.receiveaddress.dao.impl;

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

import com.selin.store.receiveaddress.dao.api.IReceiveAddressDao;
import com.selin.store.receiveaddress.entity.ReceiveAddress;
@Service
public class ReceiveAddressDao extends AbstractDao implements IReceiveAddressDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, ReceiveAddress receiveAddress) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectReceiveAddressPage", "selectReceiveAddressCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectReceiveAddressPage", null);
		return pageQuery.select(receiveAddress);
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