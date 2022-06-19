package cn.com.sk.hello.service;

import org.springframework.stereotype.Service;

@Service
public class TestErrorService {


    public void getError(){
        int a = 0;
        int b  = 1/0 ;
    }



}
