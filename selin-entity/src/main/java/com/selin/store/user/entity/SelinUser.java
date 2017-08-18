package com.selin.store.user.entity;

import org.roof.web.user.entity.User;

/**
 * Created by zhenglt on 2017/8/17.
 * 顾客
 */
public class SelinUser extends User {

    protected String tel;
    protected String open_id;


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }
}
