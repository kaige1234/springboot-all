package cn.com.sunkai.hytrix.dashboard.springbootspringcloudhytrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class SpringbootSpringcloudHytrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringcloudHytrixDashboardApplication.class, args);
	}

}
