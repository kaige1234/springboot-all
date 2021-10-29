package cn.com.sk.designmode.controller;

import cn.com.sk.designmode.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testController")
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/get")
    public void get(){
        testService.get();
    }
}
