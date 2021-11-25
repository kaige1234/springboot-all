package cn.com.sunkai.ribbon.springbootspringcloudribbontwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootSpringcloudRibbontwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringcloudRibbontwoApplication.class, args);
	}

}
