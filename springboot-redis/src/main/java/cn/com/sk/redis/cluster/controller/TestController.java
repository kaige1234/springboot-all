package cn.com.sk.redis.cluster.controller;

import cn.com.sk.redis.cluster.UserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
@Slf4j
@RestController
@RequestMapping("/testController")
public class TestController {

    @Autowired
    private RedisTemplate stringRedisTemplate;

    @RequestMapping("/get")
    public String get(int a){

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<a ;i++){
            executorService.execute(()->{
                stringRedisTemplate.opsForValue().set("test:sunkai","ddd");
            });
        }

        return (String) stringRedisTemplate.opsForValue().get("test:sunkai");
    }

    @RequestMapping("/dd")
    public String dd(){
        byte[] bytes = stringRedisTemplate.getConnectionFactory().getConnection().get("test:sunkai".getBytes());
        return new String(bytes);
    }

    @RequestMapping("/setEntity")
    public String setEntity(){
        UserInfo userInfo = new UserInfo();
        userInfo.setCode("sk_12345");
        //userInfo.setId(1111L);
        userInfo.setName("sunkai");
        String s = JSON.toJSONString(userInfo);
        stringRedisTemplate.opsForHash().putAll("userinfo", JSONObject.parseObject(s));
        log.info("保存成功");
        Object ob = stringRedisTemplate.opsForHash().get("userinfo", new HashMap<String, Object>());
        log.info(ob.toString());
        return "success";
    }

}
