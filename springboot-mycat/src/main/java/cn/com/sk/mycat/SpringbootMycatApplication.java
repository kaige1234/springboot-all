package cn.com.sk.mycat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.com.sk.mycat.mapper")
public class SpringbootMycatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMycatApplication.class, args);
	}

}
