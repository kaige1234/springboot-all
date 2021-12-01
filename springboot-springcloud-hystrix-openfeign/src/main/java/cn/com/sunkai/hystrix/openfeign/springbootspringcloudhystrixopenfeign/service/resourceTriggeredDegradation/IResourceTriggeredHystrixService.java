package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service.resourceTriggeredDegradation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IResourceTriggeredHystrixService implements ResourceTriggeredHystrixService{


    @Override
    public void getResource() {
        System.out.println("getResource 正常业务");
    }

    @Override
    public void insert(String str) {
        System.out.println(" insert  正常业务");
    }
}
