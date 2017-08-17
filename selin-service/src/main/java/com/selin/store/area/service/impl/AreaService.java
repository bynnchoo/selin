package com.selin.store.area.service.impl;

import java.io.Serializable;
import java.util.List;

import org.roof.roof.dataaccess.api.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.selin.store.StateEnum;
import com.selin.store.area.dao.api.IAreaDao;
import com.selin.store.area.entity.Area;
import com.selin.store.area.entity.AreaVo;
import com.selin.store.area.service.api.IAreaService;

@Service
public class AreaService implements IAreaService {
	private IAreaDao areaDao;

	public String findPathtoroot(Long id) {
		Area area = new Area(id);
		AreaVo areavo = this.load(area);
		String pathroot = "";
		if (areavo.getParent_id().longValue() == 0L) {
			pathroot = areavo.getName();
		} else {
			pathroot = this.findPathtoroot(id, pathroot);
		}
		return pathroot;
	}

	public String findPathtoroot(Long id, String pathroot) {
		Area area = new Area(id);
		AreaVo areavo = this.load(area);
		pathroot = areavo.getName() + pathroot;
		if (areavo.getParent_id().longValue() != 0L) {
			pathroot = this.findPathtoroot(areavo.getParent_id(), pathroot);
		}
		return pathroot;
	}

	public AreaVo tree() {
		AreaVo parent = new AreaVo();
		parent.setParent_id(0L);
		List<AreaVo> list = selectForList(parent);
		for (AreaVo vo : list) {
			tree(vo);
		}
		parent.setAreaList(list);
		return parent;
	}

	public void tree(AreaVo areaVo) {
		AreaVo child = new AreaVo();
		child.setParent_id(areaVo.getId());
		List<AreaVo> list = selectForList(child);
		for (AreaVo vo : list) {
			tree(vo);
		}
		areaVo.setAreaList(list);
	}

	public Serializable save(Area area) {
		return areaDao.save(area);
	}

	public void delete(Area area) {
		areaDao.delete(area);
	}

	public void deleteByExample(Area area) {
		areaDao.deleteByExample(area);
	}

	public void update(Area area) {
		areaDao.update(area);
	}

	public void updateIgnoreNull(Area area) {
		areaDao.updateIgnoreNull(area);
	}

	public void updateByExample(Area area) {
		areaDao.update("updateByExampleArea", area);
	}

	public AreaVo load(Area area) {
		return (AreaVo) areaDao.reload(area);
	}

	public AreaVo selectForObject(Area area) {
		return (AreaVo) areaDao.selectForObject("selectArea", area);
	}

	public List<AreaVo> selectForList(Area area) {
		return (List<AreaVo>) areaDao.selectForList("selectArea", area);
	}

	public Page page(Page page, Area area) {
		return areaDao.page(page, area);
	}

	@Autowired
	public void setIAreaDao(@Qualifier("areaDao") IAreaDao areaDao) {
		this.areaDao = areaDao;
	}

}
