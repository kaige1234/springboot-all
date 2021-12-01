package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service.resourceTriggeredDegradation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
@FeignClient(value = "resource-triggered-hystrix",
        fallback = ResourceTriggeredHystrixFallBackSerivce.ResourceTriggeredHystrixFallBack.class)
public interface ResourceTriggeredHystrixFallBackSerivce extends ResourceTriggeredHystrixService{
    @Component
    class ResourceTriggeredHystrixFallBack implements ResourceTriggeredHystrixFallBackSerivce{

        @Override
        public void getResource() {
            System.out.println("getResource 熔断");
        }

        @Override
        public void insert(String str) {
            System.out.println("insert 熔断");
        }
    }
}
