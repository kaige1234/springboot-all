package cn.com.sunkai.hystrix.springbootspringcloudhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(value = {"cn.com.sunkai.hystrix.springbootspringcloudhystrix"
		,"cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service"})
@EnableFeignClients(basePackages = {"cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service"
		,"cn.com.sunkai.hystrix.springbootspringcloudhystrix"})

public class SpringbootSpringcloudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringcloudHystrixApplication.class, args);
	}

}
