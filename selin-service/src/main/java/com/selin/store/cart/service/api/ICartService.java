package com.selin.store.cart.service.api;

import com.selin.store.cart.entity.CartVo;
import com.selin.store.product.entity.ProductVo;

import java.util.List;

/**
 * Created by lenovo on 2017/8/19.
 */
public interface ICartService {
    public void add(CartVo vo);

    void clear(CartVo vo);

    void delete(CartVo vo);

    List<ProductVo> list(Long salesman_id, Long customer_id);
}
