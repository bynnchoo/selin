package com.selin.store;

/**
 * Created by lenovo on 2017/8/13.
 */
public enum StateEnum {

    usable(1L, "可用"),
    unusable(0L, "不可用");


    private Long code;
    private String display;

    private StateEnum(Long code, String display) {
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
