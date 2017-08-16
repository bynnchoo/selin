package com.selin.store.orderevent.service.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.roof.roof.dataaccess.api.Page;
import org.roof.web.user.entity.User;

import com.selin.store.order.entity.OrderVo;
import com.selin.store.orderevent.entity.OrderEvent;
import com.selin.store.orderevent.entity.OrderEventEnum;
import com.selin.store.orderevent.entity.OrderEventVo;

public interface IOrderEventService {

	// 事件编码生成
	public String createEventCode(OrderEventEnum eventEnum, Date date) throws Exception;

	public Object onOrderEvent(Object source, OrderEventEnum eventType, User user) throws Exception;

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	public abstract Serializable save(OrderEvent orderEvent);

	/**
	 * 按对象中的主键进行删除，如果是DRDS，还需要添加拆分键
	 */
	public abstract void delete(OrderEvent orderEvent);

	/**
	 * 按对象中的非空属性作为条件，进行删除
	 */
	public abstract void deleteByExample(OrderEvent orderEvent);

	/**
	 * 按对象中的主键进行所有属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void update(OrderEvent orderEvent);

	/**
	 * 按对象中的主键进行所有非空属性的修改，如果是DRDS，还需要添加拆分键
	 */
	public abstract void updateIgnoreNull(OrderEvent orderEvent);

	/**
	 * 按对象中的非空属性作为条件，进行修改
	 */
	public abstract void updateByExample(OrderEvent orderEvent);

	/**
	 * 按对象中的主键进行数据加载，如果是DRDS，还需要添加拆分键
	 */
	public abstract OrderEventVo load(OrderEvent orderEvent);

	/**
	 * 按对象中的非空属性作为条件，进行查询实体
	 */
	public abstract OrderEventVo selectForObject(OrderEvent orderEvent);

	/**
	 * 按对象中的非空属性作为条件，进行查询列表
	 */
	public abstract List<OrderEventVo> selectForList(OrderEvent orderEvent);

	/**
	 * 按对象中的非空属性作为条件，进行分页查询
	 */
	public abstract Page page(Page page, OrderEvent orderEvent);

}