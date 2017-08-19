package com.selin.store.cart.entity;

/**
 * Created by lenovo on 2017/8/19.
 */
public class Cart {
    protected Long norms_id;//规格id
    protected Integer num;//数量


    public Long getNorms_id() {
        return norms_id;
    }

    public void setNorms_id(Long norms_id) {
        this.norms_id = norms_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
