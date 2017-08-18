package com.selin.store.user.dao.impl;

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

import com.selin.store.user.dao.api.ISelinUserDao;
import com.selin.store.user.entity.SelinUser;
@Service
public class SelinUserDao extends AbstractDao implements ISelinUserDao {
	
	private PageQueryFactory<PageQuery> pageQueryFactory;
	
	public Page page(Page page, SelinUser user) {
		IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectUserPage", "selectUserCount");
		//IPageQuery pageQuery = pageQueryFactory.getPageQuery(page,"selectUserPage", null);
		return pageQuery.select(user);
	}

	@Override
	public Long readSelinUserCount(SelinUser selinUser) {
		return (Long) this.daoSupport.selectForObject("readSelinUserCount",selinUser);
	}

	@Override
	public int addOpenUserRole(Long userId, Long roleId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("roleId", roleId);
		return this.update("addSelinUserRole", params);
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