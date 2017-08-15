package com.selin.store.inventory.service.api;

import java.util.List;
import java.io.Serializable;

import org.roof.roof.dataaccess.api.Page;
import com.selin.store.inventory.entity.Inventory;
import com.selin.store.inventory.entity.InventoryVo;

public interface IInventoryService {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(Inventory inventory);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(Inventory inventory);
	
	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(Inventory inventory);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(Inventory inventory);
	
	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(Inventory inventory);
	
	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(Inventory inventory);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract InventoryVo load(Inventory inventory);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract InventoryVo selectForObject(Inventory inventory);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<InventoryVo> selectForList(Inventory inventory);
	
	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, Inventory inventory);

	/**
	 * 更改库存
	 * @param pro_norms_id 规格id 具体某件商品
	 * @param warehouse_id 仓库
	 * @param num 变化数量 +是入库，-是出库
	 * @return boolean 是否成功
	 */
	public abstract boolean setStock(Long pro_norms_id,Long warehouse_id,Integer num);


}