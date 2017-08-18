package com.selin.store.user.dao.api;

import com.selin.store.user.entity.SelinUser;
import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.roof.dataaccess.api.Page;


public interface ISelinUserDao extends IDaoSupport {
    Page page(Page page, SelinUser user);

    Long readSelinUserCount(SelinUser selinUser);

    int addOpenUserRole(Long id, Long id1);
}