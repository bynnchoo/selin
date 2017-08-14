package com.selin.store.buyorder.service.api;

import java.util.List;
import java.io.Serializable;

import org.roof.roof.dataaccess.api.Page;
import com.selin.store.buyorder.entity.BuyOrder;
import com.selin.store.buyorder.entity.BuyOrderVo;

public interface IBuyOrderService {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(BuyOrder buyOrder);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(BuyOrder buyOrder);
	
	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(BuyOrder buyOrder);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(BuyOrder buyOrder);
	
	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(BuyOrder buyOrder);
	
	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(BuyOrder buyOrder);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract BuyOrderVo load(BuyOrder buyOrder);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract BuyOrderVo selectForObject(BuyOrder buyOrder);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<BuyOrderVo> selectForList(BuyOrder buyOrder);
	
	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, BuyOrder buyOrder);

}