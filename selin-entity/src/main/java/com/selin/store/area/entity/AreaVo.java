package com.selin.store.area.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_area <br/>
 *         描述：地区信息表 <br/>
 */
public class AreaVo extends Area {

	private List<AreaVo> areaList;

	public AreaVo() {
		super();
	}

	public AreaVo(Long id) {
		super();
		this.id = id;
	}

	public List<AreaVo> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<AreaVo> areaList) {
		this.areaList = areaList;
	}

}
