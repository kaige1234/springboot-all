package cn.com.sk.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/testProfie")
public class TestProfie {

    private static String profile;
    @Value("${spring.profiles.active}")
    public   String profile2;

    @PostConstruct
    public void init(){
        System.out.println(profile2);
    }

    @GetMapping("/get")
    public String get(){
        return profile2;
    }


}
