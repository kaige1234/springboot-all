package cn.com.sk.redis.cluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("/testController")
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/get")
    public String get(int a){

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<a ;i++){
            executorService.execute(()->{
                stringRedisTemplate.opsForValue().set("test:sunkai","ddd");
            });
        }

        return stringRedisTemplate.opsForValue().get("test:sunkai");
    }

    @RequestMapping("/dd")
    public String dd(){
        byte[] bytes = stringRedisTemplate.getConnectionFactory().getConnection().get("test:sunkai".getBytes());
        return new String(bytes);
    }

}
