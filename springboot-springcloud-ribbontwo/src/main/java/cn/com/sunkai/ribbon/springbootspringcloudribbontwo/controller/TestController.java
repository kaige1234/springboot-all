package cn.com.sunkai.ribbon.springbootspringcloudribbontwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getTest")
    public String getTest(){
        System.out.println("nihao");
        return "服务调用成功";
    }

}
