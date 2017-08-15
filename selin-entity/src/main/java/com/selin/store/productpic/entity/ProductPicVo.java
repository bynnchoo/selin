package com.selin.store.productpic.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_product_pic <br/>
 *         描述：商品图片 <br/>
 */
public class ProductPicVo extends ProductPic {

	private List<ProductPicVo> productPicList;

	public ProductPicVo() {
		super();
	}

	public ProductPicVo(Long id) {
		super();
		this.id = id;
	}

	public List<ProductPicVo> getProductPicList() {
		return productPicList;
	}

	public void setProductPicList(List<ProductPicVo> productPicList) {
		this.productPicList = productPicList;
	}

}
