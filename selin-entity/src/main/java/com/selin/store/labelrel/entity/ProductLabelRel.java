package com.selin.store.labelrel.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_product_label_rel <br/>
 *         描述：w_product_label_rel <br/>
 */
public class ProductLabelRel implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected Long product_id;// product_id
	protected Long label_id;// label_id

	public ProductLabelRel() {
		super();
	}

	public ProductLabelRel(Long id) {
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
	
	public Long getLabel_id() {
		return label_id;
	}
	public void setLabel_id(Long label_id) {
		this.label_id = label_id;
	}
}
