package com.selin.store.category.service.impl;

import java.io.Serializable;
import java.util.List;

import com.selin.store.StateEnum;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.category.dao.api.ICategoryDao;
import com.selin.store.category.entity.Category;
import com.selin.store.category.entity.CategoryVo;
import com.selin.store.category.service.api.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
	private ICategoryDao categoryDao;

	public Serializable save(Category category){
		return categoryDao.save(category);
	}

	public void delete(Category category){
		categoryDao.delete(category);
	}
	
	public void deleteByExample(Category category){
		categoryDao.deleteByExample(category);
	}

	public void update(Category category){
		categoryDao.update(category);
	}
	
	public void updateIgnoreNull(Category category){
		categoryDao.updateIgnoreNull(category);
	}
		
	public void updateByExample(Category category){
		categoryDao.update("updateByExampleCategory", category);
	}

	public CategoryVo load(Category category){
		return (CategoryVo)categoryDao.reload(category);
	}
	
	public CategoryVo selectForObject(Category category){
		return (CategoryVo)categoryDao.selectForObject("selectCategory",category);
	}
	
	public List<CategoryVo> selectForList(Category category){
		return (List<CategoryVo>)categoryDao.selectForList("selectCategory",category);
	}
	
	public Page page(Page page, Category category) {
		return categoryDao.page(page, category);
	}

	public CategoryVo tree() {
		CategoryVo parent = new CategoryVo();
		parent.setParent_id(0L);
		parent.setState(StateEnum.usable.getCode());
		List<CategoryVo> list = selectForList(parent);
		for (CategoryVo vo :list){
			tree(vo);
		}
		parent.setCategoryList(list);
		return parent;
	}

	public void tree(CategoryVo category) {
		CategoryVo child = new CategoryVo();
		child.setParent_id(category.getId());
		child.setState(StateEnum.usable.getCode());
		List<CategoryVo> list = selectForList(child);
		for (CategoryVo vo :list){
			tree(vo);
		}
		category.setCategoryList(list);
	}

	@Autowired
	public void setICategoryDao(
			@Qualifier("categoryDao") ICategoryDao  categoryDao) {
		this.categoryDao = categoryDao;
	}
	

}
