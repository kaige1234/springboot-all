package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service.resourceTriggeredDegradation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


public interface ResourceTriggeredHystrixService {

    @GetMapping("/getResource")
    public void getResource();

    @PostMapping("/insert")
    public void insert(String str);
}
