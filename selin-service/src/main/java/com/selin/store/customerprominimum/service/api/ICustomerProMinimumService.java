package com.selin.store.customerprominimum.service.api;

import java.io.Serializable;
import java.util.List;

import org.roof.roof.dataaccess.api.Page;

import com.selin.store.customer.entity.Customer;
import com.selin.store.customerprominimum.entity.CustomerProMinimum;
import com.selin.store.customerprominimum.entity.CustomerProMinimumVo;
import com.selin.store.orderpros.entity.OrderPros;

public interface ICustomerProMinimumService {

	/**
	 * 订单审核通过，把该客户最新的针对性金额存入
	 * 
	 * @param pros
	 */
	public abstract void saveCustomerProMinByOrder(List<OrderPros> pros, Long cus_id);

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract CustomerProMinimumVo load(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract CustomerProMinimumVo selectForObject(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<CustomerProMinimumVo> selectForList(CustomerProMinimum customerProMinimum);

	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, CustomerProMinimum customerProMinimum);

}