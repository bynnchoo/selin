package com.selin.store.user.service.impl;

import com.selin.store.user.dao.api.ICustomerDao;
import com.selin.store.user.entity.Customer;
import com.selin.store.user.service.api.ICustomerService;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/8/17.
 */
@Service("CustomerService1")
public class CustomerService extends SelinUserService implements ICustomerService {

    private ICustomerDao customerDao;

    @Override
    public void register(Customer user) {
        customerDao.save(user);
    }
}
