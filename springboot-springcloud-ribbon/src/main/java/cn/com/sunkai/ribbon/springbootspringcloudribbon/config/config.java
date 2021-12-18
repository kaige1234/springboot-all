package cn.com.sunkai.ribbon.springbootspringcloudribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        //设置连接的超时时间
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(3000);
        return new RestTemplate(requestFactory);
    }
}
