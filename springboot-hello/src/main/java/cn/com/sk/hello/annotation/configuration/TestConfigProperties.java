package cn.com.sk.hello.annotation.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("cn.sunkai.test")
public class TestConfigProperties {

    private String name;
    private String code;

}
