package cn.com.sk.hello.controller;

import cn.com.sk.hello.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/outStack")
public class OutStack {

    @Autowired
    private User user;

    @RequestMapping("/getUser")
    public String getUser(){
        user.getUser();
        return "调用-getUser";
    }



}
