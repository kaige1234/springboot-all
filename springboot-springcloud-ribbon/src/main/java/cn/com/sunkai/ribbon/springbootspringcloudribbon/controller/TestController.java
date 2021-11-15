package cn.com.sunkai.ribbon.springbootspringcloudribbon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getTest")
    public String getTest(){
        log.info("9036");
        return restTemplate.getForObject("http://sping-ribbon-02:9034/test/getTest",String.class);
    }

}
