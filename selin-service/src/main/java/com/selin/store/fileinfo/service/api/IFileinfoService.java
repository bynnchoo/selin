package com.selin.store.fileinfo.service.api;

import java.util.List;
import java.io.Serializable;

import org.roof.roof.dataaccess.api.Page;
import com.selin.store.fileinfo.entity.Fileinfo;
import com.selin.store.fileinfo.entity.FileinfoVo;

public interface IFileinfoService {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(Fileinfo fileinfo);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(Fileinfo fileinfo);
	
	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(Fileinfo fileinfo);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(Fileinfo fileinfo);
	
	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(Fileinfo fileinfo);
	
	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(Fileinfo fileinfo);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract FileinfoVo load(Fileinfo fileinfo);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract FileinfoVo selectForObject(Fileinfo fileinfo);
	
	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<FileinfoVo> selectForList(Fileinfo fileinfo);
	
	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, Fileinfo fileinfo);

}