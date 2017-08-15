package com.selin.store.productpic.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.productpic.dao.api.IProductPicDao;
import com.selin.store.productpic.entity.ProductPic;
import com.selin.store.productpic.entity.ProductPicVo;
import com.selin.store.productpic.service.api.IProductPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductPicService implements IProductPicService {
	private IProductPicDao productPicDao;

	public Serializable save(ProductPic productPic){
		return productPicDao.save(productPic);
	}

	public void delete(ProductPic productPic){
		productPicDao.delete(productPic);
	}
	
	public void deleteByExample(ProductPic productPic){
		productPicDao.deleteByExample(productPic);
	}

	public void update(ProductPic productPic){
		productPicDao.update(productPic);
	}
	
	public void updateIgnoreNull(ProductPic productPic){
		productPicDao.updateIgnoreNull(productPic);
	}
		
	public void updateByExample(ProductPic productPic){
		productPicDao.update("updateByExampleProductPic", productPic);
	}

	public ProductPicVo load(ProductPic productPic){
		return (ProductPicVo)productPicDao.reload(productPic);
	}
	
	public ProductPicVo selectForObject(ProductPic productPic){
		return (ProductPicVo)productPicDao.selectForObject("selectProductPic",productPic);
	}
	
	public List<ProductPicVo> selectForList(ProductPic productPic){
		return (List<ProductPicVo>)productPicDao.selectForList("selectProductPic",productPic);
	}
	
	public Page page(Page page, ProductPic productPic) {
		return productPicDao.page(page, productPic);
	}

	@Override
	public void deleteByProduct_id(Long product_id) {
		productPicDao.delete("deleteProductPicByProductId",product_id);
	}

	@Autowired
	public void setIProductPicDao(
			@Qualifier("productPicDao") IProductPicDao  productPicDao) {
		this.productPicDao = productPicDao;
	}
	

}
