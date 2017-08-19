package com.selin.store.cart.action;

import com.selin.store.cart.entity.CartVo;
import com.selin.store.cart.service.api.ICartService;
import org.roof.spring.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhenglt on 2017/8/19.
 */
@Controller
@RequestMapping("selin/cartAction")
public class CartAction {

    //@Autowired
    private ICartService cartService;

    @RequestMapping("/add")
    public @ResponseBody Result add (CartVo vo){
        if(vo.getCustomer_id() == null){
            return new Result(Result.FAIL,"顾客id不能为空");
        }
        cartService.add(vo);
        return new Result();
    };


    @RequestMapping("/delete")
    public @ResponseBody Result delete (CartVo vo){
        if(vo.getCustomer_id() == null){
            return new Result(Result.FAIL,"顾客id不能为空");
        }
        cartService.delete(vo);

        return new Result();
    };

    @RequestMapping("/clear")
    public @ResponseBody Result clear (CartVo vo){
        if(vo.getCustomer_id() == null){
            return new Result(Result.FAIL,"顾客id不能为空");
        }
        cartService.clear(vo);
        return new Result();
    };


    @RequestMapping("/list")
    public @ResponseBody Result list (Long salesman_id,Long customer_id){
        cartService.list(salesman_id,customer_id);
        return new Result();
    };

}
