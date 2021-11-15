package cn.com.sunkai.gateway.springbootspringcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("cn.com.sunkai.gateway")
public class SpringbootSpringcloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringcloudGatewayApplication.class, args);
	}

}
