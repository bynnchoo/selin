package com.selin.store.cart.service.impl;

import com.selin.store.cart.entity.Cart;
import com.selin.store.cart.entity.CartVo;
import com.selin.store.cart.service.api.ICartService;
import com.selin.store.product.entity.Product;
import com.selin.store.product.entity.ProductVo;
import com.selin.store.product.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/19.
 */
@Service
public class CartService implements ICartService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private IProductService productService;

    private String redisKey="cart:";

    @Override
    public void add(CartVo vo) {
        String key =  createKey(vo);
        for (Cart cart:vo.getCarts()) {
            redisTemplate.boundHashOps(key).put(cart.getNorms_id(),cart.getNum());
        }
    }

    @Override
    public void clear(CartVo vo) {
        String key =  createKey(vo);
        redisTemplate.delete(key);
    }

    @Override
    public void delete(CartVo vo) {
        String key =  createKey(vo);
        for (Cart cart:vo.getCarts()) {
            redisTemplate.boundHashOps(key).delete(cart.getNorms_id());
        }
    }

    @Override
    public List<ProductVo> list(Long salesman_id, Long customer_id) {
        CartVo vo = new CartVo();
        vo.setCustomer_id(customer_id);
        vo.setSalesman_id(salesman_id);
        String key =  createKey(vo);
        BoundHashOperations<String,Long,Integer>  boundHashOperations = redisTemplate.boundHashOps(key);
        Map<Long,Integer> map =  boundHashOperations.entries();
        List<ProductVo> vos = new ArrayList<>();
        for (Long norms_id : map.keySet()) {
            ProductVo productVo =  productService.selectInfoByNormsId(norms_id);
            if (productVo != null){
                productVo.setNum(map.get(norms_id));
            }
            vos.add(productVo);
        }
        return vos;
    }


    private String createKey(CartVo vo){
        return redisKey+vo.getSalesman_id()+"_"+vo.getCustomer_id();
    }

}
