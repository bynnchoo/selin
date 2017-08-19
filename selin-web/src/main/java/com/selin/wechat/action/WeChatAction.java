package com.selin.wechat.action;

import com.selin.core.wechat.WeChatHander;
import com.selin.store.user.entity.SelinUser;
import org.apache.commons.lang3.StringUtils;
import org.roof.spring.Result;
import org.roof.web.user.service.api.BaseUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by zhenglt on 2017/8/17.
 */
@Controller
@RequestMapping("selin/weChatAction")
public class WeChatAction {

    @Autowired
    private WeChatHander weChatHander;


    @RequestMapping("/store")
    public String store(HttpServletRequest request, Model model) throws IOException {
        UserDetails userDetails = BaseUserContext.getCurrentUser(request);
        if(userDetails != null){
            return "登录成功页面";
        }else{
            String code = request.getParameter("code");
            System.out.println("code="+code);
            if (StringUtils.isNotEmpty(code)) {
                String openid = weChatHander.getOpenid(code);
                System.out.println("openid="+code);
                if(StringUtils.isBlank(openid)){
                    return "";
                }else {
                    SelinUser user =  weChatHander.findUserByOpenid(openid);
                    if (user == null){
                        return "注册页面";
                    }
                    BaseUserContext.putCurrentUser(user,request);
                    return "登录成功页面";
                }
            }else {
                return "没有code请在微信登录";
            }
        }
    }



}
