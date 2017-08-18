package com.selin.store.user.service.api;

import java.util.List;
import java.io.Serializable;

import com.selin.store.user.entity.SelinUser;
import org.roof.roof.dataaccess.api.Page;

public interface ISelinUserService {

    public SelinUser load(Long id);

    void register(SelinUser user);

    Boolean sameUsername(Long id, String username);

    List<SelinUser> select(SelinUser user);
}