package com.selin.store.orderpros.service.impl;

import java.io.Serializable;
import java.util.List;
import org.roof.roof.dataaccess.api.Page;
import com.selin.store.orderpros.dao.api.IOrderProsDao;
import com.selin.store.orderpros.entity.OrderPros;
import com.selin.store.orderpros.entity.OrderProsVo;
import com.selin.store.orderpros.service.api.IOrderProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderProsService implements IOrderProsService {
	private IOrderProsDao orderProsDao;

	public Serializable save(OrderPros orderPros) {
		return orderProsDao.save(orderPros);
	}

	public void delete(OrderPros orderPros) {
		orderProsDao.delete(orderPros);
	}

	public void deleteByExample(OrderPros orderPros) {
		orderProsDao.deleteByExample(orderPros);
	}

	public void update(OrderPros orderPros) {
		orderProsDao.update(orderPros);
	}

	public void updateIgnoreNull(OrderPros orderPros) {
		orderProsDao.updateIgnoreNull(orderPros);
	}

	public void updateByExample(OrderPros orderPros) {
		orderProsDao.update("updateByExampleOrderPros", orderPros);
	}

	public OrderProsVo load(OrderPros orderPros) {
		return (OrderProsVo) orderProsDao.reload(orderPros);
	}

	public OrderProsVo selectForObject(OrderPros orderPros) {
		return (OrderProsVo) orderProsDao.selectForObject("selectOrderPros", orderPros);
	}

	public List<OrderProsVo> selectForList(OrderPros orderPros) {
		return (List<OrderProsVo>) orderProsDao.selectForList("selectOrderPros", orderPros);
	}

	public List<OrderProsVo> selectForListByOrderNum(String orderNum) {
		return (List<OrderProsVo>) orderProsDao.selectForList("selectOrderProsByOrderNum", orderNum);
	}

	public Page page(Page page, OrderPros orderPros) {
		return orderProsDao.page(page, orderPros);
	}

	@Autowired
	public void setIOrderProsDao(@Qualifier("orderProsDao") IOrderProsDao orderProsDao) {
		this.orderProsDao = orderProsDao;
	}

}
