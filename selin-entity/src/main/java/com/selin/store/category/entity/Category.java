package com.selin.store.category.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_category <br/>
 *         描述：w_category <br/>
 */
public class Category implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// 主键
	protected String name;// 名称
	protected Integer level;// 层级
	protected Long state;// 是否可用
	protected Long parent_id;// 父id
	protected Integer is_leaf;// 是否叶子节点

	public Category() {
		super();
	}

	public Category(Long id) {
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
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	
	public Integer getIs_leaf() {
		return is_leaf;
	}
	public void setIs_leaf(Integer is_leaf) {
		this.is_leaf = is_leaf;
	}
}
