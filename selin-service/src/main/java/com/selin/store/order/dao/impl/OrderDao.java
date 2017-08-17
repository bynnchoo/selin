package com.selin.store.order.dao.impl;

import org.roof.dataaccess.PageQuery;
import org.roof.roof.dataaccess.api.AbstractDao;
import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.IPageQuery;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.selin.store.order.dao.api.IOrderDao;
import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderVo;

@Service
public class OrderDao extends AbstractDao implements IOrderDao {

	private PageQueryFactory<PageQuery> pageQueryFactory;

	public Page page(Page page, Order order) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page, "selectOrderPage", "selectOrderCount");
		// IPageQuery pageQuery =
		// pageQueryFactory.getPageQuery(page,"selectOrderPage", null);
		return pageQuery.select(order);
	}

	@Autowired
	public void setPageQueryFactory(@Qualifier("pageQueryFactory") PageQueryFactory<PageQuery> pageQueryFactory) {
		this.pageQueryFactory = pageQueryFactory;
	}

	@Autowired
	public void setDaoSupport(@Qualifier("roofDaoSupport") IDaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}

	@Override
	public Page selectOrderPageForSale(Page page, OrderVo orderVo) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page, "selectOrderPageForSale", "selectOrderCountForSale");
		return pageQuery.select(orderVo);
	}

}