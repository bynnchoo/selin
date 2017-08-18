package com.selin.core.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.selin.core.exception.SelinException;
import com.selin.core.http.HttpClientUtil;
import com.selin.core.wechat.bean.WeChatToken;
import com.selin.store.user.entity.SelinUser;
import com.selin.store.user.service.api.ISelinUserService;
import org.apache.commons.lang3.StringUtils;
import org.roof.commons.PropertiesUtil;
import org.roof.web.user.entity.User;
import org.roof.web.user.service.api.BaseUserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundKeyOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/8/17.
 */
@Service
public class WeChatHander {
    private Logger LOGGER = LoggerFactory.getLogger(WeChatHander.class);

    private RedisTemplate<String,String> redisTemplate;

    private ISelinUserService selinUserService;
    @Value("selin.wx.appid")
    private String appid ;
    @Value("selin.wx.secret")
    private String secret ;
    @Value("selin.wx.access_token_url")
    private String token_url ;
    @Value("selin.wx.html_access_token_url")
    private String html_token_url ;


    private String redis_key = "wechat:token";

    public String getAccess_tokenByHttp(){
       String s = HttpClientUtil.get(token_url+"&appid="+appid+"&secret="+secret);
        WeChatToken token = JSON.parseObject(s,WeChatToken.class);
        if(token == null){
            LOGGER.error("获取微信token失败");
            throw new SelinException("获取微信token失败");
        }else {
            BoundValueOperations redis = redisTemplate.boundValueOps(redis_key);
            redis.set(token.getAccess_token());
            redis.expire(token.getExpires_in(), TimeUnit.SECONDS);
        }
        return token.getAccess_token();
    };

    public String getAccess_token(){
        BoundValueOperations<String,String> redis = redisTemplate.boundValueOps(redis_key);
        String s = redis.get();
        if (StringUtils.isNotBlank(s)){
            return s;
        }else {
            return getAccess_tokenByHttp();
        }
    };


    /**
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
     */
    public String post(String url, String code) throws IOException {
        Map<String, Object> postData = new HashMap<String, Object>();
        postData.put("appid", appid);
        postData.put("secret", secret);
        postData.put("code", code);
        postData.put("grant_type", PropertiesUtil.getPorpertyString("epo.wx.grant_type"));
        return HttpClientUtil.post(url, postData);
    }

    /**
     * 获得微信用户的openid
     *
     * @param code
     * @return
     */
    public String getOpenid(String code) throws IOException {
        String body = this.post(html_token_url, code);
        JSONObject obj = JSON.parseObject(body);
        String openid = null;
        if (obj.containsKey("openid")) {
            openid = obj.getString("openid");
        }
        return openid;
    }

    public SelinUser findUserByOpenid(String openid) {
        SelinUser find = null;
        if (org.apache.commons.lang.StringUtils.isNotEmpty(openid)) {
            SelinUser user = new SelinUser();
            user.setOpen_id(openid);
            user.setEnabled(true);
            List<SelinUser> list = selinUserService.select(user);
            if (list.size() >= 1) {
                find = list.get(0);
            }
        }
        return find;
    }

}
