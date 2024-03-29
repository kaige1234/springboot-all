package cn.com.sunkai.gateway.springbootspringcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootSpringcloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringcloudGatewayApplication.class, args);
	}

}
