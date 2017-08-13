package com.selin.store.brand.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_brand <br/>
 *         描述：w_brand <br/>
 */
public class Brand implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// 主键
	protected String name;// 名称
	protected Long state;// 是否可用

	public Brand() {
		super();
	}

	public Brand(Long id) {
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
}
