package com.selin.store.product.entity;

/**
 * Created by zhenglt on 2017/8/15.
 */
public enum ProductState {

    PUTAWAY(1L, "上架"),
    SOLDOUT(0L, "下架");

    private Long code;
    private String display;

    private ProductState(Long code, String display) {
        this.code = code;
        this.display = display;
    }

    public Long getCode() {
        return code;
    }

    public String getDisplay() {
        return display;
    }
}
