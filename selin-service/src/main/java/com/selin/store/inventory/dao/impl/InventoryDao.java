package com.selin.store.inventory.dao.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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

import com.selin.store.inventory.dao.api.IInventoryDao;
import com.selin.store.inventory.entity.Inventory;
@Service
public class InventoryDao extends AbstractDao implements IInventoryDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, Inventory inventory) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectInventoryPage", "selectInventoryCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectInventoryPage", null);
		return pageQuery.select(inventory);
	}

	public Integer setStock(Long id, Integer newNum, Integer num) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("newNum",newNum);
		map.put("oldNum",num);
		return this.daoSupport.update("setStock",map);
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