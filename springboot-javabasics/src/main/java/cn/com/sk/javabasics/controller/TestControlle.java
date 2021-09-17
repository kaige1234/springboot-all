package cn.com.sk.javabasics.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunkai
 * @title: TestControlle
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/9/1514:23
 */
@RestController
@RequestMapping("/test")
public class TestControlle {

    @RequestMapping("/get")
    public String get(){
        return "test";
    }


}
