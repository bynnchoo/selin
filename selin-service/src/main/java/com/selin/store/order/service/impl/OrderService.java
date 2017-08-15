package com.selin.store.order.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.roof.roof.dataaccess.api.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.selin.store.customer.dao.api.ICustomerDao;
import com.selin.store.customer.entity.Customer;
import com.selin.store.customer.entity.CustomerVo;
import com.selin.store.generate.GenerateOrderNum;
import com.selin.store.norms.entity.ProductNormsVo;
import com.selin.store.order.dao.api.IOrderDao;
import com.selin.store.order.entity.Order;
import com.selin.store.order.entity.OrderVo;
import com.selin.store.order.service.api.IOrderService;
import com.selin.store.orderevent.entity.OrderEnum;
import com.selin.store.receiveaddress.entity.ReceiveAddress;

@Service
public class OrderService implements IOrderService {
	private IOrderDao orderDao;

	@Autowired
	private ICustomerDao customerDao;

	public OrderVo orderAdd(CustomerVo cus, List<ProductNormsVo> pros, ReceiveAddress address) {
		// 客户不能为空
		if (cus == null) {
		}
		// 商品清单不能为空
		if (pros == null && pros.size() == 0) {
		}
		// 客户收货地址
		if (address == null && address.getId() == null) {

		}
		Customer c = customerDao.load(Customer.class, cus.getId());
		Order o = new Order();
		o.setOrder_num(GenerateOrderNum.generate(OrderEnum.order.getCodePrefix()));// 订单号
		o.setCreate_date(new Date());// 下单时间
		o.setCus_num(c.getCus_num());// 客户编码
		o.setCus_id(c.getId());// 客户主键
		o.setCus_name(c.getCus_name());// 客户名称

		orderDao.save(o);

		return null;
	}

	public OrderVo orderConfirm(String orderNum, List<ProductNormsVo> pros) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVo orderFinanceConfirm(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVo dispatchConfirm(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVo back(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVo cancel(String orderNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable save(Order order) {
		return orderDao.save(order);
	}

	public void delete(Order order) {
		orderDao.delete(order);
	}

	public void deleteByExample(Order order) {
		orderDao.deleteByExample(order);
	}

	public void update(Order order) {
		orderDao.update(order);
	}

	public void updateIgnoreNull(Order order) {
		orderDao.updateIgnoreNull(order);
	}

	public void updateByExample(Order order) {
		orderDao.update("updateByExampleOrder", order);
	}

	public OrderVo load(Order order) {
		return (OrderVo) orderDao.reload(order);
	}

	public OrderVo selectForObject(Order order) {
		return (OrderVo) orderDao.selectForObject("selectOrder", order);
	}

	public List<OrderVo> selectForList(Order order) {
		return (List<OrderVo>) orderDao.selectForList("selectOrder", order);
	}

	public Page page(Page page, Order order) {
		return orderDao.page(page, order);
	}

	@Autowired
	public void setIOrderDao(@Qualifier("orderDao") IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
