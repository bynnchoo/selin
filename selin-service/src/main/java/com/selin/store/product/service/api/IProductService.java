package com.selin.store.product.service.api;

import java.util.List;
import java.io.Serializable;

import com.selin.store.product.entity.ProductDto;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.product.entity.Product;
import com.selin.store.product.entity.ProductVo;

public interface IProductService {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(Product product);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(Product product);
	
	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(Product product);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(Product product);
	
	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(Product product);
	
	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(Product product);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract ProductVo load(Product product);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract ProductVo selectForObject(Product product);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<ProductVo> selectForList(Product product);
	
	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, Product product);

	public abstract Page productNomrsPage(Page page, Product product);


	public abstract List<ProductVo> selectProductNormsList(Product product);

	public abstract Page productNomrsStockPage(Page page, Product product);

	public abstract void create(ProductDto product);

	ProductVo selectInfoByNormsId(Long norms_id);
}