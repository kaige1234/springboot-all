package cn.com.sk.hello.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {



    public String excuMethod(){
        System.out.println("TestService - excuMethod");
        return "方法调用完成";
    }
}
