package com.selin.store.customerprominimum.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.roof.roof.dataaccess.api.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.selin.store.customerprominimum.dao.api.ICustomerProMinimumDao;
import com.selin.store.customerprominimum.entity.CustomerProMinimum;
import com.selin.store.customerprominimum.entity.CustomerProMinimumVo;
import com.selin.store.customerprominimum.service.api.ICustomerProMinimumService;
import com.selin.store.orderpros.entity.OrderPros;

@Service
public class CustomerProMinimumService implements ICustomerProMinimumService {
	private ICustomerProMinimumDao customerProMinimumDao;

	public void saveCustomerProMinByOrder(List<OrderPros> pros, Long cus_id) {
		CustomerProMinimum oldmin = new CustomerProMinimum();
		oldmin.setCus_id(cus_id);
		List<CustomerProMinimumVo> oldmins = this.selectForList(oldmin);
		for (OrderPros orderPros : pros) {
			Boolean tag = true;
			for (CustomerProMinimumVo minvo : oldmins) {
				if (minvo.getPro_code().equals(orderPros.getPro_code())) {// 商品编码相同
					tag = false;
					if (orderPros.getPrice() < minvo.getPrice()) {// update
						CustomerProMinimum min = new CustomerProMinimum();
						BeanUtils.copyProperties(minvo, min);
						min.setPrice(orderPros.getPrice());// 最新最低价
						customerProMinimumDao.updateIgnoreNull(min);
					}
				}
			}
			if (tag) {// insert
				CustomerProMinimum min = new CustomerProMinimum();
				min.setCreate_date(new Date());
				min.setCus_id(cus_id);
				min.setOrder_num(orderPros.getOrder_num());
				min.setPrice(orderPros.getPrice());
				min.setPro_code(orderPros.getPro_code());
				customerProMinimumDao.save(min);
			}
		}

	}

	public Serializable save(CustomerProMinimum customerProMinimum) {
		return customerProMinimumDao.save(customerProMinimum);
	}

	public void delete(CustomerProMinimum customerProMinimum) {
		customerProMinimumDao.delete(customerProMinimum);
	}

	public void deleteByExample(CustomerProMinimum customerProMinimum) {
		customerProMinimumDao.deleteByExample(customerProMinimum);
	}

	public void update(CustomerProMinimum customerProMinimum) {
		customerProMinimumDao.update(customerProMinimum);
	}

	public void updateIgnoreNull(CustomerProMinimum customerProMinimum) {
		customerProMinimumDao.updateIgnoreNull(customerProMinimum);
	}

	public void updateByExample(CustomerProMinimum customerProMinimum) {
		customerProMinimumDao.update("updateByExampleCustomerProMinimum", customerProMinimum);
	}

	public CustomerProMinimumVo load(CustomerProMinimum customerProMinimum) {
		return (CustomerProMinimumVo) customerProMinimumDao.reload(customerProMinimum);
	}

	public CustomerProMinimumVo selectForObject(CustomerProMinimum customerProMinimum) {
		return (CustomerProMinimumVo) customerProMinimumDao.selectForObject("selectCustomerProMinimum",
				customerProMinimum);
	}

	public List<CustomerProMinimumVo> selectForList(CustomerProMinimum customerProMinimum) {
		return (List<CustomerProMinimumVo>) customerProMinimumDao.selectForList("selectCustomerProMinimum",
				customerProMinimum);
	}

	public Page page(Page page, CustomerProMinimum customerProMinimum) {
		return customerProMinimumDao.page(page, customerProMinimum);
	}

	@Autowired
	public void setICustomerProMinimumDao(
			@Qualifier("customerProMinimumDao") ICustomerProMinimumDao customerProMinimumDao) {
		this.customerProMinimumDao = customerProMinimumDao;
	}

}
