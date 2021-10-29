package cn.com.sk.designmode.controller;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Async;

/**
 * @author sunkai
 * @title: Test
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2116:41
 */
public class Test {
    public static void main(String[] args){
        String str = new String();
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.getBean("");
    }
}
