package com.selin.store.invoice.service.api;

import java.util.List;
import java.io.Serializable;

import org.roof.roof.dataaccess.api.Page;
import com.selin.store.invoice.entity.Invoice;
import com.selin.store.invoice.entity.InvoiceVo;

public interface IInvoiceService {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(Invoice invoice);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(Invoice invoice);
	
	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(Invoice invoice);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(Invoice invoice);
	
	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(Invoice invoice);
	
	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(Invoice invoice);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract InvoiceVo load(Invoice invoice);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract InvoiceVo selectForObject(Invoice invoice);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<InvoiceVo> selectForList(Invoice invoice);
	
	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, Invoice invoice);

}