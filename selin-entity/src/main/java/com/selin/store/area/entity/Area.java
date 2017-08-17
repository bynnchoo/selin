package com.selin.store.area.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_area <br/>
 *         描述：地区信息表 <br/>
 */
public class Area implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected Long parent_id;// parent_id
	protected String name;// name
	protected Integer type;// 1省 2市 3区
	protected String zip_code;// zip_code
	protected String quhao;// quhao
	protected Boolean status;// status

	public Area() {
		super();
	}

	public Area(Long id) {
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
	
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	
	public String getQuhao() {
		return quhao;
	}
	public void setQuhao(String quhao) {
		this.quhao = quhao;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
}
