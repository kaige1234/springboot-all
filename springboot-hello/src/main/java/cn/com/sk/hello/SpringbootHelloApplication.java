package cn.com.sk.hello;

import cn.com.sk.hello.service.ImportTestClass;
import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import(ImportTestClass.class)

public class SpringbootHelloApplication {

    public static void main(String[] args) {
       SpringApplication.run(SpringbootHelloApplication.class, args);
    }

}
