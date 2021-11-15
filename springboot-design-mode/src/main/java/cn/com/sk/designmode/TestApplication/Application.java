package cn.com.sk.designmode.TestApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sunkai
 * @title: Application
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/317:45
 */
public class Application {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.getBean("");

    }
}
