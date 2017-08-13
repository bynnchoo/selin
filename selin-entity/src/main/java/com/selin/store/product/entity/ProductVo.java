package com.selin.store.product.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_product <br/>
 *         描述：w_product <br/>
 */
public class ProductVo extends Product {

	private List<ProductVo> productList;

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

}
