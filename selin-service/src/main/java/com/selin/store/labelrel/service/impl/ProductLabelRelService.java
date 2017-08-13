package com.selin.store.labelrel.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.labelrel.dao.api.IProductLabelRelDao;
import com.selin.store.labelrel.entity.ProductLabelRel;
import com.selin.store.labelrel.entity.ProductLabelRelVo;
import com.selin.store.labelrel.service.api.IProductLabelRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductLabelRelService implements IProductLabelRelService {
	private IProductLabelRelDao productLabelRelDao;

	public Serializable save(ProductLabelRel productLabelRel){
		return productLabelRelDao.save(productLabelRel);
	}

	public void delete(ProductLabelRel productLabelRel){
		productLabelRelDao.delete(productLabelRel);
	}
	
	public void deleteByExample(ProductLabelRel productLabelRel){
		productLabelRelDao.deleteByExample(productLabelRel);
	}

	public void update(ProductLabelRel productLabelRel){
		productLabelRelDao.update(productLabelRel);
	}
	
	public void updateIgnoreNull(ProductLabelRel productLabelRel){
		productLabelRelDao.updateIgnoreNull(productLabelRel);
	}
		
	public void updateByExample(ProductLabelRel productLabelRel){
		productLabelRelDao.update("updateByExampleProductLabelRel", productLabelRel);
	}

	public ProductLabelRelVo load(ProductLabelRel productLabelRel){
		return (ProductLabelRelVo)productLabelRelDao.reload(productLabelRel);
	}
	
	public ProductLabelRelVo selectForObject(ProductLabelRel productLabelRel){
		return (ProductLabelRelVo)productLabelRelDao.selectForObject("selectProductLabelRel",productLabelRel);
	}
	
	public List<ProductLabelRelVo> selectForList(ProductLabelRel productLabelRel){
		return (List<ProductLabelRelVo>)productLabelRelDao.selectForList("selectProductLabelRel",productLabelRel);
	}
	
	public Page page(Page page, ProductLabelRel productLabelRel) {
		return productLabelRelDao.page(page, productLabelRel);
	}

	@Autowired
	public void setIProductLabelRelDao(
			@Qualifier("productLabelRelDao") IProductLabelRelDao  productLabelRelDao) {
		this.productLabelRelDao = productLabelRelDao;
	}
	

}
