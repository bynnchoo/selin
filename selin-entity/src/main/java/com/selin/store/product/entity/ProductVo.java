package com.selin.store.product.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_product <br/>
 *         描述：w_product <br/>
 */
public class ProductVo extends Product {

	private List<ProductVo> productList;

	private String colour;// 颜色
	private String size;// 尺码
	private Integer num;//数量

	private String brand_name;
	private String supplier_name;
	private String category_name;


	public ProductVo() {
		super();
	}

	public ProductVo(Long id) {
		super();
		this.id = id;
	}

	public List<ProductVo> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductVo> productList) {
		this.productList = productList;
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


	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}


	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
}
