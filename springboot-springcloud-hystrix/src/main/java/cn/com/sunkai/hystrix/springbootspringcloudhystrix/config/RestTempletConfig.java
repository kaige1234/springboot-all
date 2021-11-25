package cn.com.sunkai.hystrix.springbootspringcloudhystrix.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunkai
 * @title: RestTempletConfig
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/2514:41
 */
@Configuration
public class RestTempletConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };
}
