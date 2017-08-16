package com.selin.store.invoice.dao.impl;

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

import com.selin.store.invoice.dao.api.IInvoiceDao;
import com.selin.store.invoice.entity.Invoice;
@Service
public class InvoiceDao extends AbstractDao implements IInvoiceDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, Invoice invoice) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectInvoicePage", "selectInvoiceCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectInvoicePage", null);
		return pageQuery.select(invoice);
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