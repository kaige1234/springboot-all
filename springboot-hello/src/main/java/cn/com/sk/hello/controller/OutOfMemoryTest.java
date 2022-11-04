package cn.com.sk.hello.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/outOfMemoryTest")
public class OutOfMemoryTest {

    @RequestMapping("/getOutOfMemoryTest")
    public void getOutOfMemoryTest(){
        List<String> list = new ArrayList<String>();
        for(;;){
            list.add("sunkai");
        }
    }

}
