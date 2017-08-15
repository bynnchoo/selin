package com.selin.store.norms.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_product_norms <br/>
 *         描述：w_product_norms <br/>
 */
public class ProductNormsVo extends ProductNorms {

	private List<ProductNormsVo> productNormsList;

	private Integer num;// 件数

	public ProductNormsVo() {
		super();
	}

	public ProductNormsVo(Long id) {
		super();
		this.id = id;
	}

	public List<ProductNormsVo> getProductNormsList() {
		return productNormsList;
	}

	public void setProductNormsList(List<ProductNormsVo> productNormsList) {
		this.productNormsList = productNormsList;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
