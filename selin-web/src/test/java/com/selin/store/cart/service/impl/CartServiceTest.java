package com.selin.store.cart.service.impl;

import com.selin.store.cart.entity.Cart;
import com.selin.store.cart.entity.CartVo;
import com.selin.store.cart.service.api.ICartService;
import com.selin.store.product.entity.ProductVo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.List;

/**
 * CartService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>zhenglt 19, 2017</pre>
 */
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class CartServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ICartService cartService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(CartVo vo)
     */
    @Test
    public void testAdd() throws Exception {
        Cart c1 = new Cart();
        c1.setNorms_id(1L);
        c1.setNum(2);
        Cart c2 = new Cart();
        c2.setNorms_id(2L);
        c1.setNum(5);
        List<Cart> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        CartVo vo = new CartVo();
        vo.setCarts(list);
        cartService.add(vo);
    }

    /**
     * Method: clear(CartVo vo)
     */
    @Test
    public void testClear() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: delete(CartVo vo)
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: list(Long salesman_id, Long customer_id)
     */
    @Test
    public void testList() throws Exception {
        List<ProductVo> vos = cartService.list(null,null);
        System.out.println(vos);
        System.exit(1);
    }





} 
