package cn.com.sk.javabasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//开启异步任务
@EnableAsync
public class SpringbootJavabasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJavabasicsApplication.class, args);
	}

}
