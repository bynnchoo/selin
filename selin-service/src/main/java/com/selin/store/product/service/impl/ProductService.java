package com.selin.store.product.service.impl;

import java.io.Serializable;
import java.util.List;

import com.selin.core.exception.SelinException;
import com.selin.store.label.entity.Label;
import com.selin.store.labelrel.entity.ProductLabelRel;
import com.selin.store.labelrel.service.api.IProductLabelRelService;
import com.selin.store.norms.entity.ProductNorms;
import com.selin.store.norms.service.api.IProductNormsService;
import com.selin.store.product.entity.ProductDto;
import com.selin.store.productpic.entity.ProductPic;
import com.selin.store.productpic.service.api.IProductPicService;
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

	private IProductLabelRelService productLabelRelService;
	private IProductNormsService productNormsService;
	private IProductPicService productPicService;


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

	@Override
	public Page productNomrsPage(Page page, Product product) {
		return productDao.productNomrsPage(page,product);
	}

	@Override
	public List<ProductVo> selectProductNormsList(Product product) {
		return productDao.selectProductNormsList(product);
	}

	@Override
	public Page productNomrsStockPage(Page page, Product product) {
		return productDao.productNomrsStockPage(page,product);
	}

	@Override
	public void create(ProductDto product) {
		Long id  = (Long) this.save(product);
		//保存规格
		if(product.getNormsList() != null){
			for (ProductNorms norms :product.getNormsList()){
				norms.setProduct_id(id);
				productNormsService.save(norms);
			}
		}
		//保存标签关系
		if(product.getLabels() != null){
			for (Label label :product.getLabels()){
				ProductLabelRel rel = new ProductLabelRel();
				rel.setLabel_id(label.getId());
				rel.setProduct_id(id);
				productLabelRelService.save(rel);
			}
		}
		//保存图片
		if(product.getPicList() != null){
			for (ProductPic pic :product.getPicList()){
				pic.setProduct_id(id);
				productPicService.save(pic);
			}
		}
	}

	@Override
	public ProductVo selectInfoByNormsId(Long norms_id) {
		return (ProductVo) productDao.selectForObject("selectProductInfoByNormsId",norms_id);
	}

	public void update(ProductDto product) {
		Long id = product.getId();
		this.update(product);
		//规格不能修改

		//更新标签关系
		productLabelRelService.deleteByProduct_id(id);
		if(product.getLabels() != null){
			for (Label label :product.getLabels()){
				ProductLabelRel rel = new ProductLabelRel();
				rel.setLabel_id(label.getId());
				rel.setProduct_id(id);
				productLabelRelService.save(rel);
			}
		}
		//保存图片
		productPicService.deleteByProduct_id(id);
		if(product.getPicList() != null){
			for (ProductPic pic :product.getPicList()){
				pic.setProduct_id(id);
				productPicService.save(pic);
			}
		}
	}

	@Autowired
	public void setIProductDao(
			@Qualifier("productDao") IProductDao  productDao) {
		this.productDao = productDao;
	}
	

}
