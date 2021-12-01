package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testFeignController")
public class TestFeignController {

    @RequestMapping("/get")
    public String get(){
        return null;
    }
}
