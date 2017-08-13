package com.selin.store.product.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.product.dao.api.IProductDao;
import com.selin.store.product.entity.Product;
import com.selin.store.product.entity.ProductVo;
import com.selin.store.product.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
	private IProductDao productDao;

	public Serializable save(Product product){
		return productDao.save(product);
	}

	public void delete(Product product){
		productDao.delete(product);
	}
	
	public void deleteByExample(Product product){
		productDao.deleteByExample(product);
	}

	public void update(Product product){
		productDao.update(product);
	}
	
	public void updateIgnoreNull(Product product){
		productDao.updateIgnoreNull(product);
	}
		
	public void updateByExample(Product product){
		productDao.update("updateByExampleProduct", product);
	}

	public ProductVo load(Product product){
		return (ProductVo)productDao.reload(product);
	}
	
	public ProductVo selectForObject(Product product){
		return (ProductVo)productDao.selectForObject("selectProduct",product);
	}
	
	public List<ProductVo> selectForList(Product product){
		return (List<ProductVo>)productDao.selectForList("selectProduct",product);
	}
	
	public Page page(Page page, Product product) {
		return productDao.page(page, product);
	}

	@Autowired
	public void setIProductDao(
			@Qualifier("productDao") IProductDao  productDao) {
		this.productDao = productDao;
	}
	

}
