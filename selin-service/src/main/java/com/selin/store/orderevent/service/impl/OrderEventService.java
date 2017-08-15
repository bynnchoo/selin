package com.selin.store.orderevent.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.orderevent.dao.api.IOrderEventDao;
import com.selin.store.orderevent.entity.OrderEvent;
import com.selin.store.orderevent.entity.OrderEventVo;
import com.selin.store.orderevent.service.api.IOrderEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderEventService implements IOrderEventService {
	private IOrderEventDao orderEventDao;

	public Serializable save(OrderEvent orderEvent){
		return orderEventDao.save(orderEvent);
	}

	public void delete(OrderEvent orderEvent){
		orderEventDao.delete(orderEvent);
	}
	
	public void deleteByExample(OrderEvent orderEvent){
		orderEventDao.deleteByExample(orderEvent);
	}

	public void update(OrderEvent orderEvent){
		orderEventDao.update(orderEvent);
	}
	
	public void updateIgnoreNull(OrderEvent orderEvent){
		orderEventDao.updateIgnoreNull(orderEvent);
	}
		
	public void updateByExample(OrderEvent orderEvent){
		orderEventDao.update("updateByExampleOrderEvent", orderEvent);
	}

	public OrderEventVo load(OrderEvent orderEvent){
		return (OrderEventVo)orderEventDao.reload(orderEvent);
	}
	
	public OrderEventVo selectForObject(OrderEvent orderEvent){
		return (OrderEventVo)orderEventDao.selectForObject("selectOrderEvent",orderEvent);
	}
	
	public List<OrderEventVo> selectForList(OrderEvent orderEvent){
		return (List<OrderEventVo>)orderEventDao.selectForList("selectOrderEvent",orderEvent);
	}
	
	public Page page(Page page, OrderEvent orderEvent) {
		return orderEventDao.page(page, orderEvent);
	}

	@Autowired
	public void setIOrderEventDao(
			@Qualifier("orderEventDao") IOrderEventDao  orderEventDao) {
		this.orderEventDao = orderEventDao;
	}
	

}
