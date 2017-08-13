package com.selin.store.category.entity;

import java.util.List;

/**
 * @author 模版生成 <br/>
 *         表名： w_category <br/>
 *         描述：w_category <br/>
 */
public class CategoryVo extends Category {

	private List<CategoryVo> categoryList;

	public CategoryVo() {
		super();
	}

	public CategoryVo(Long id) {
		super();
		this.id = id;
	}

	public List<CategoryVo> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryVo> categoryList) {
		this.categoryList = categoryList;
	}

}
