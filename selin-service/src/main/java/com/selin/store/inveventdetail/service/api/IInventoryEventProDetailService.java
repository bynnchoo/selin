package com.selin.store.inveventdetail.service.api;

import java.util.List;
import java.io.Serializable;

import org.roof.roof.dataaccess.api.Page;
import com.selin.store.inveventdetail.entity.InventoryEventProDetail;
import com.selin.store.inveventdetail.entity.InventoryEventProDetailVo;

public interface IInventoryEventProDetailService {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(InventoryEventProDetail inventoryEventProDetail);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(InventoryEventProDetail inventoryEventProDetail);
	
	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(InventoryEventProDetail inventoryEventProDetail);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(InventoryEventProDetail inventoryEventProDetail);
	
	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(InventoryEventProDetail inventoryEventProDetail);
	
	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(InventoryEventProDetail inventoryEventProDetail);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract InventoryEventProDetailVo load(InventoryEventProDetail inventoryEventProDetail);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract InventoryEventProDetailVo selectForObject(InventoryEventProDetail inventoryEventProDetail);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<InventoryEventProDetailVo> selectForList(InventoryEventProDetail inventoryEventProDetail);
	
	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, InventoryEventProDetail inventoryEventProDetail);

	public abstract Serializable saveList(List<InventoryEventProDetail> inventoryEventProDetails);


}