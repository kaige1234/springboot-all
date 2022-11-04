package cn.com.sk.hello.annotation.configuration;


import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TestConfigProperties.class)
public class TestEnableConfigProperties {

    private final TestConfigProperties testConfigProperties;

    public TestEnableConfigProperties(TestConfigProperties testConfigProperties) {
        this.testConfigProperties = testConfigProperties;
    }

    @Bean
    public User getUser(){
        User user = new User();
        user.setUserCode(testConfigProperties.getCode());
        user.setUserName(testConfigProperties.getName());
        return user;
    }
}
