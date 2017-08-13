package com.selin.store.norms.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_product_norms <br/>
 *         描述：w_product_norms <br/>
 */
public class ProductNorms implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// 主键
	protected Long product_id;// 商品ID
	protected String colour;// 颜色
	protected String size;// 尺码

	public ProductNorms() {
		super();
	}

	public ProductNorms(Long id) {
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
	
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
