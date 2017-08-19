package com.selin.store.user.service.impl;

import org.springframework.stereotype.Service;

import com.selin.store.user.dao.api.ICustomerDao;
import com.selin.store.user.entity.Customer;
import com.selin.store.user.service.api.ICustomerService;

/**
 * Created by lenovo on 2017/8/17.
 */
@Service
public class CustomerService extends SelinUserService implements ICustomerService {

	private ICustomerDao customerDao;

	public Customer load(Long id) {
		Customer customer = customerDao.load(Customer.class, id);
		return customer;
	};

	@Override
	public void register(Customer user) {
		customerDao.save(user);
	}
}
