package com.selin.store.category.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.category.entity.Category;

public interface ICategoryDao extends IDaoSupport {
	Page page(Page page, Category category);
}