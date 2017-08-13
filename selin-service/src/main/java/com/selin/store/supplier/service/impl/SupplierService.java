package com.selin.store.supplier.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.supplier.dao.api.ISupplierDao;
import com.selin.store.supplier.entity.Supplier;
import com.selin.store.supplier.entity.SupplierVo;
import com.selin.store.supplier.service.api.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SupplierService implements ISupplierService {
	private ISupplierDao supplierDao;

	public Serializable save(Supplier supplier){
		return supplierDao.save(supplier);
	}

	public void delete(Supplier supplier){
		supplierDao.delete(supplier);
	}
	
	public void deleteByExample(Supplier supplier){
		supplierDao.deleteByExample(supplier);
	}

	public void update(Supplier supplier){
		supplierDao.update(supplier);
	}
	
	public void updateIgnoreNull(Supplier supplier){
		supplierDao.updateIgnoreNull(supplier);
	}
		
	public void updateByExample(Supplier supplier){
		supplierDao.update("updateByExampleSupplier", supplier);
	}

	public SupplierVo load(Supplier supplier){
		return (SupplierVo)supplierDao.reload(supplier);
	}
	
	public SupplierVo selectForObject(Supplier supplier){
		return (SupplierVo)supplierDao.selectForObject("selectSupplier",supplier);
	}
	
	public List<SupplierVo> selectForList(Supplier supplier){
		return (List<SupplierVo>)supplierDao.selectForList("selectSupplier",supplier);
	}
	
	public Page page(Page page, Supplier supplier) {
		return supplierDao.page(page, supplier);
	}

	@Autowired
	public void setISupplierDao(
			@Qualifier("supplierDao") ISupplierDao  supplierDao) {
		this.supplierDao = supplierDao;
	}
	

}
