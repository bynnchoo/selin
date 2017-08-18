package com.selin.store.user.service.api;

import com.selin.store.user.entity.Customer;
import com.selin.store.user.entity.SelinUser;

/**
 * Created by zhenglt on 2017/8/17.
 */
public interface ICustomerService extends ISelinUserService {

    void register(Customer user);


}
