package com.selin.store.warehouse.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_warehouse <br/>
 *         描述：仓库表 <br/>
 */
public class Warehouse implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String code;// 仓库编码
	protected String name;// 仓库名称
	protected String address;// 仓库地址
	protected Long area_id;// 区域id

	public Warehouse() {
		super();
	}

	public Warehouse(Long id) {
		super();
		this.id = id;
	}
	
	@Id// 主键
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getArea_id() {
		return area_id;
	}
	public void setArea_id(Long area_id) {
		this.area_id = area_id;
	}
}
