package com.selin.store.product.entity;

import com.selin.store.label.entity.Label;
import com.selin.store.norms.entity.ProductNorms;
import com.selin.store.productpic.entity.ProductPic;

import java.util.List;

/**
 * Created by zhenglt on 2017/8/13.
 */
public class ProductDto extends  Product {

    private List<Label> labels;
    private List<ProductNorms> normsList;
    private List<ProductPic> picList;

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<ProductNorms> getNormsList() {
        return normsList;
    }

    public void setNormsList(List<ProductNorms> normsList) {
        this.normsList = normsList;
    }


    public List<ProductPic> getPicList() {
        return picList;
    }

    public void setPicList(List<ProductPic> picList) {
        this.picList = picList;
    }
}
