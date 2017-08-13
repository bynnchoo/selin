package com.selin.store.brand.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_brand <br/>
 *         描述：w_brand <br/>
 */
public class BrandVo extends Brand {

	private List<BrandVo> brandList;

	public BrandVo() {
		super();
	}

	public BrandVo(Long id) {
		super();
		this.id = id;
	}

	public List<BrandVo> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<BrandVo> brandList) {
		this.brandList = brandList;
	}

}
