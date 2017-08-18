package com.selin.store.user.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.selin.store.user.dao.api.ISelinUserDao;
import com.selin.store.user.entity.SelinUser;
import com.selin.store.user.entity.SelinUserVo;
import com.selin.store.user.service.api.ISelinUserService;
import org.apache.commons.lang3.StringUtils;
import org.roof.roof.dataaccess.api.Page;
import org.roof.web.org.dao.api.IOrgDao;
import org.roof.web.role.dao.api.IRoleDao;
import org.roof.web.role.entity.BaseRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SelinUserService implements ISelinUserService {
	@Autowired
	private ISelinUserDao selinUserDao;

	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IOrgDao orgDao;

	public SelinUserVo selectForObject(SelinUser user){
		return (SelinUserVo)selinUserDao.selectForObject("selectUser",user);
	}

	@Autowired
	public void setSelinUserDao(@Qualifier("selinUserDao") ISelinUserDao selinUserDao) {
		this.selinUserDao = selinUserDao;
	}

	@Override
	public SelinUser load(Long id) {
		SelinUser selinUser = selinUserDao.load(SelinUser.class, id);
		Set<?> baseRoles = roleDao.selectByUser(id);
		selinUser.setRoles((Set<BaseRole>) baseRoles);
		if (selinUser.getOrg() != null && selinUser.getOrg().getId() != null) {
			selinUser.setOrg(orgDao.load(selinUser.getOrg().getId()));
		}
		return selinUser;
	}

	protected void addRoles(SelinUser OpenUser) {
		if (OpenUser.getRoles() != null) {
			for (BaseRole role : OpenUser.getRoles()) {
				if (role != null && role.getId() != null) {
					selinUserDao.addOpenUserRole(OpenUser.getId(), role.getId());
				}
			}
		}
	}

	@Override
	public void register(SelinUser user) {
		selinUserDao.save(user);
		addRoles(user);
	}

	@Override
	public Boolean sameUsername(Long id, String username) {
		SelinUser selinUser = new SelinUser();
		selinUser.setUsername(username);
		Long l = selinUserDao.readSelinUserCount(selinUser);
		if (l == 0) {
			return false;
		}
		if (id != null && id != 0L) {
			selinUser = selinUserDao.load(SelinUser.class, id);
			if (StringUtils.equals(username, selinUser.getUsername())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<SelinUser> select(SelinUser user) {
		return null;
	}
}
