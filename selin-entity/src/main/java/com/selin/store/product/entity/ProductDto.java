package com.selin.store.product.entity;

import com.selin.store.label.entity.Label;
import com.selin.store.norms.entity.ProductNorms;

import java.util.List;

/**
 * Created by zhenglt on 2017/8/13.
 */
public class ProductDto extends  Product {

    private List<Label> labels;
    private List<ProductNorms> normss;



}
