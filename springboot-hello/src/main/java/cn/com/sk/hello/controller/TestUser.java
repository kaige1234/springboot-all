package cn.com.sk.hello.controller;

import cn.com.sk.hello.annotation.configuration.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/testUser")
public class TestUser {

    @Autowired
    private User user;

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    @RequestMapping("/getUser")
    public String getUser(){
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        String put = concurrentHashMap.put("22", "22");
        String put1 = concurrentHashMap.put("22", "23");
        System.out.print(put1 +"----"+put);
        return user.toString();
    }

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static int getConcurrentHashMap(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException();
        int cap = ((initialCapacity >= (MAXIMUM_CAPACITY >>> 1)) ?
                MAXIMUM_CAPACITY :
                tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
        return cap;
    }

    public static void main(String[] args) {
        TestUser testUser = new TestUser();
        testUser.getUser();
       // int result = TestUser.getConcurrentHashMap(6);
        //System.out.print(result);
    }
}
