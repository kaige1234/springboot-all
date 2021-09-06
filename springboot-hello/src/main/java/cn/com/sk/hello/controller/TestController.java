package cn.com.sk.hello.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sk
 * @title: TestController
 * @projectName springboot-all
 * @description: 测试controller
 * @date 2021/1/199:34
 */
@RestController
public class TestController {
    public static void main(String[] args){
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("string","string");
    }
}
