package com.selin.store.label.dao.api;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;

import com.selin.store.label.entity.Label;

public interface ILabelDao extends IDaoSupport {
	Page page(Page page, Label label);
}