package cn.com.sk.hello;

import cn.com.sk.hello.service.ImportTestClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import(ImportTestClass.class)
public class SpringbootHelloApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootHelloApplication.class, args);
        Object importTestClass = run.getBean("cn.com.sk.hello.service.ImportTestClass");
        System.out.println(importTestClass);

    }

}
