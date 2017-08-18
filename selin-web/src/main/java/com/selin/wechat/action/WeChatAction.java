package com.selin.wechat.action;

import com.selin.core.wechat.WeChatHander;
import com.selin.store.user.entity.SelinUser;
import org.apache.commons.lang3.StringUtils;
import org.roof.spring.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
        String code = request.getParameter("code");
        if (StringUtils.isNotEmpty(code)) {
            String openid = weChatHander.getOpenid(code);

        }

            return "";
    }

    /*public String forward() {
        try {
            Map<String, Object> map = super.getParams();
            String code = (String) map.get("code");
            if (StringUtils.isNotEmpty(code)) {
                String openid = wxService.getOpenid(code);
                super.addParameter("openid", openid);
                super.addParameter("code", code);
                if (StringUtils.isNotEmpty(openid)) {
                    User user = wxService.findUserByOpenid(openid);
                    super.addParameter("user", user);
                    // 未绑定
                    if (user == null || user.getId() == null) {
                        result = "/epo_mobile/user/binding/binding.jsp";
                        return JSP;
                    } else {
                        result = (String) super.getParamByName("aim_url");
                        return REDIRECT;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        result = "/epo_mobile/user/binding/binding.jsp";
        return JSP;
    }*/



}
