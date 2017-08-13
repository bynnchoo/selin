package com.selin.store.labelrel.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_product_label_rel <br/>
 *         描述：w_product_label_rel <br/>
 */
public class ProductLabelRelVo extends ProductLabelRel {

	private List<ProductLabelRelVo> productLabelRelList;

	public ProductLabelRelVo() {
		super();
	}

	public ProductLabelRelVo(Long id) {
		super();
		this.id = id;
	}

	public List<ProductLabelRelVo> getProductLabelRelList() {
		return productLabelRelList;
	}

	public void setProductLabelRelList(List<ProductLabelRelVo> productLabelRelList) {
		this.productLabelRelList = productLabelRelList;
	}

}
