package com.selin.store.user.action;

import com.alibaba.fastjson.JSONPath;
import com.selin.store.supplier.entity.Supplier;
import com.selin.store.user.entity.Customer;
import com.selin.store.user.entity.SelinUser;
import com.selin.store.user.service.api.ICustomerService;
import com.selin.store.user.service.api.ISelinUserService;
import org.apache.commons.lang3.StringUtils;
import org.roof.roof.dataaccess.api.Page;
import org.roof.roof.dataaccess.api.PageUtils;
import org.roof.spring.Result;
import org.roof.web.role.entity.BaseRole;
import org.roof.web.role.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhenglt on 2017/8/17.
 */
@Controller
@RequestMapping("selin/user")
public class SelinUserAction {

    @Autowired
    private ISelinUserService selinUserService;
    @Autowired
    private ICustomerService customerService;


    @RequestMapping("/selin/register")
    public @ResponseBody
    Result register(SelinUser user, HttpServletRequest request, Model model) {
        Long[] rolesIds ={1450L};

        if(StringUtils.isBlank(user.getTel())){
            return new Result(Result.FAIL,"手机号码不能为空");
        }
        if(StringUtils.isBlank(user.getName())){
            return new Result(Result.FAIL,"姓名不能为空");
        }
        if(StringUtils.isBlank(user.getPassword())){
            return new Result(Result.FAIL,"密码不能为空");
        }
        if (rolesIds != null) {
            Set<BaseRole> roles = new HashSet<BaseRole>();
            for (Long roleId : rolesIds) {
                roles.add(new Role(roleId, null));
            }
            user.setRoles(roles);
        }
        user.setCreate_date(new Date());
        if (!JSONPath.contains(user, "$.org.id")) {
            user.setOrg(null);
        }
        selinUserService.register(user);
        return new Result(Result.SUCCESS);
    }

    @RequestMapping("/customer/register")
    public @ResponseBody
    Result register(Customer user, HttpServletRequest request, Model model) {
        Long[] rolesIds ={1450L};

        if(StringUtils.isBlank(user.getTel())){
            return new Result(Result.FAIL,"手机号码不能为空");
        }
        if(StringUtils.isBlank(user.getName())){
            return new Result(Result.FAIL,"姓名不能为空");
        }
        if(StringUtils.isBlank(user.getPassword())){
            return new Result(Result.FAIL,"密码不能为空");
        }
        if (rolesIds != null) {
            Set<BaseRole> roles = new HashSet<BaseRole>();
            for (Long roleId : rolesIds) {
                roles.add(new Role(roleId, null));
            }
            user.setRoles(roles);
        }
        user.setCreate_date(new Date());
        if (!JSONPath.contains(user, "$.org.id")) {
            user.setOrg(null);
        }
        customerService.register(user);
        return new Result(Result.SUCCESS);
    }



    @RequestMapping({"/sameUsername"})
    @ResponseBody
    public Boolean sameUsername(String username, Long id) {
        Boolean b =  this.selinUserService.sameUsername(id, username);
        return Boolean.valueOf(!b);
    }




}
