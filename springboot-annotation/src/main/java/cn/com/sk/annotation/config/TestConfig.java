package cn.com.sk.annotation.config;

import cn.com.sk.annotation.entity.PramasTest;
import cn.com.sk.annotation.entity.Test;
import cn.com.sk.annotation.entity.TestImpl1;
import cn.com.sk.annotation.entity.TestImpl2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public PramasTest pramasTest(){
        return new PramasTest();
    }

    @ConditionalOnMissingBean( Test.class)
    @Bean
    public Test get1(PramasTest pramasTest){
        return new TestImpl1(pramasTest);
    }

    @Bean
    public Test get2(PramasTest pramasTest){
        return new TestImpl2(pramasTest);
    }
}
