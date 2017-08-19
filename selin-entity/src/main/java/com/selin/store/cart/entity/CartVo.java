package com.selin.store.cart.entity;

import java.util.List;

/**
 * Created by lenovo on 2017/8/19.
 */
public class CartVo extends Cart {

    private List<Cart> carts;

    private Long salesman_id;
    private Long customer_id;


    public CartVo() {
        super();
    }


    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public Long getSalesman_id() {
        return salesman_id;
    }

    public void setSalesman_id(Long salesman_id) {
        this.salesman_id = salesman_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}
