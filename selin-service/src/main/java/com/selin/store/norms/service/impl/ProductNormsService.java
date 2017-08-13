package com.selin.store.norms.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.norms.dao.api.IProductNormsDao;
import com.selin.store.norms.entity.ProductNorms;
import com.selin.store.norms.entity.ProductNormsVo;
import com.selin.store.norms.service.api.IProductNormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductNormsService implements IProductNormsService {
	private IProductNormsDao productNormsDao;

	public Serializable save(ProductNorms productNorms){
		return productNormsDao.save(productNorms);
	}

	public void delete(ProductNorms productNorms){
		productNormsDao.delete(productNorms);
	}
	
	public void deleteByExample(ProductNorms productNorms){
		productNormsDao.deleteByExample(productNorms);
	}

	public void update(ProductNorms productNorms){
		productNormsDao.update(productNorms);
	}
	
	public void updateIgnoreNull(ProductNorms productNorms){
		productNormsDao.updateIgnoreNull(productNorms);
	}
		
	public void updateByExample(ProductNorms productNorms){
		productNormsDao.update("updateByExampleProductNorms", productNorms);
	}

	public ProductNormsVo load(ProductNorms productNorms){
		return (ProductNormsVo)productNormsDao.reload(productNorms);
	}
	
	public ProductNormsVo selectForObject(ProductNorms productNorms){
		return (ProductNormsVo)productNormsDao.selectForObject("selectProductNorms",productNorms);
	}
	
	public List<ProductNormsVo> selectForList(ProductNorms productNorms){
		return (List<ProductNormsVo>)productNormsDao.selectForList("selectProductNorms",productNorms);
	}
	
	public Page page(Page page, ProductNorms productNorms) {
		return productNormsDao.page(page, productNorms);
	}

	@Autowired
	public void setIProductNormsDao(
			@Qualifier("productNormsDao") IProductNormsDao  productNormsDao) {
		this.productNormsDao = productNormsDao;
	}
	

}
