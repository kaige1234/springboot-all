package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * 该方法用来是测试feign在调用的时候熔断器熔断的方法
 *
 * feign的api接口
 */
public interface OrderService {

    @GetMapping("/orders")
    String orders();
}
