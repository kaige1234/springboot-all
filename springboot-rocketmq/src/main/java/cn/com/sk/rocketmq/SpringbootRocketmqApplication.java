package cn.com.sk.rocketmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("cn.com.sk.rocketmq.mapper")
public class SpringbootRocketmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRocketmqApplication.class, args);
	}

}
