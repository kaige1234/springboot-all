package cn.com.sunkai.ribbon.springbootspringcloudribbon.controller;

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
        return restTemplate.getForObject("http://sping-ribbon-02:9034/test/getTest",String.class);
    }

}
