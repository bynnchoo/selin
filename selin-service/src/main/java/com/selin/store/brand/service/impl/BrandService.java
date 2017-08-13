package com.selin.store.brand.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.brand.dao.api.IBrandDao;
import com.selin.store.brand.entity.Brand;
import com.selin.store.brand.entity.BrandVo;
import com.selin.store.brand.service.api.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements IBrandService {
	private IBrandDao brandDao;

	public Serializable save(Brand brand){
		return brandDao.save(brand);
	}

	public void delete(Brand brand){
		brandDao.delete(brand);
	}
	
	public void deleteByExample(Brand brand){
		brandDao.deleteByExample(brand);
	}

	public void update(Brand brand){
		brandDao.update(brand);
	}
	
	public void updateIgnoreNull(Brand brand){
		brandDao.updateIgnoreNull(brand);
	}
		
	public void updateByExample(Brand brand){
		brandDao.update("updateByExampleBrand", brand);
	}

	public BrandVo load(Brand brand){
		return (BrandVo)brandDao.reload(brand);
	}
	
	public BrandVo selectForObject(Brand brand){
		return (BrandVo)brandDao.selectForObject("selectBrand",brand);
	}
	
	public List<BrandVo> selectForList(Brand brand){
		return (List<BrandVo>)brandDao.selectForList("selectBrand",brand);
	}
	
	public Page page(Page page, Brand brand) {
		return brandDao.page(page, brand);
	}

	@Autowired
	public void setIBrandDao(
			@Qualifier("brandDao") IBrandDao  brandDao) {
		this.brandDao = brandDao;
	}
	

}
