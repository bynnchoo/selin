package com.selin.store.supplier.service.api;

import java.util.List;
import java.io.Serializable;

import org.roof.roof.dataaccess.api.Page;
import com.selin.store.supplier.entity.Supplier;
import com.selin.store.supplier.entity.SupplierVo;

public interface ISupplierService {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(Supplier supplier);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(Supplier supplier);
	
	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(Supplier supplier);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(Supplier supplier);
	
	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(Supplier supplier);
	
	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(Supplier supplier);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract SupplierVo load(Supplier supplier);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract SupplierVo selectForObject(Supplier supplier);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<SupplierVo> selectForList(Supplier supplier);
	
	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, Supplier supplier);

}