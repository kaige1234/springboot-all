package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * 该方法用来是测试feign在调用的时候熔断器熔断的方法
 */
@FeignClient(value = "order-service",fallback = OrderServiceFeignClient.OrderServiceFeignClientFallback.class)
public interface OrderServiceFeignClient extends OrderService{

    @Component
    class OrderServiceFeignClientFallback implements OrderServiceFeignClient{

        @Override
        public String orders() {
            return "查询订单失败，请稍候重试";
        }


    }
}
