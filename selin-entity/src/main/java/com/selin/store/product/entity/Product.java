package com.selin.store.product.entity;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 模版生成 <br/>
 *         表名： w_product <br/>
 *         描述：w_product <br/>
 */
public class Product implements Serializable {
	// 需要手动添加非默认的serialVersionUID
	protected Long id;// id
	protected String name;// 商品名称
	protected String code;// 编码
	protected Long brand_id;// 品牌
	protected Long supplier_id;// 供应商
	protected Integer is_oneself;// 是否自己生产
	protected Long category_id;// 商品分类
	protected Double cost_price;// 成本价格
	protected Double retail_price;// 市场价
	protected Double minimum_price;// 最低市场价
	protected String accessory;// 附件
	protected String description;// 描述
	protected Long state;// 上架，下架
	protected String keyword;// 关键字
	protected Integer minimum_num;// 起订量

	public Product() {
		super();
	}

	public Product(Long id) {
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Long getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}
	
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	
	public Integer getIs_oneself() {
		return is_oneself;
	}
	public void setIs_oneself(Integer is_oneself) {
		this.is_oneself = is_oneself;
	}
	
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	
	public Double getCost_price() {
		return cost_price;
	}
	public void setCost_price(Double cost_price) {
		this.cost_price = cost_price;
	}
	
	public Double getRetail_price() {
		return retail_price;
	}
	public void setRetail_price(Double retail_price) {
		this.retail_price = retail_price;
	}
	
	public Double getMinimum_price() {
		return minimum_price;
	}
	public void setMinimum_price(Double minimum_price) {
		this.minimum_price = minimum_price;
	}
	
	public String getAccessory() {
		return accessory;
	}
	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public Integer getMinimum_num() {
		return minimum_num;
	}
	public void setMinimum_num(Integer minimum_num) {
		this.minimum_num = minimum_num;
	}
}
