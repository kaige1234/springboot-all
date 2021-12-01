package cn.com.sunkai.hystrix.springbootspringcloudhystrix.controller;

import cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service.ITestFeignService;
import cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service.OrderServiceFeignClient;
import cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service.TestFeignFallBackService;
import cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service.resourceTriggeredDegradation.ResourceTriggeredHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testFeignHystrixController")
public class TestFeignHystrixController {

    @Autowired
    private TestFeignFallBackService testFeignFallBackService;

    @Autowired
    OrderServiceFeignClient orderServiceFeignClient;

    @Autowired
    ResourceTriggeredHystrixService resourceTriggeredHystrixService;

    /**
     * 为了校验超时熔断
     * @return
     */
    @PostMapping("/getOrders")
    public String getOrders(){
        return orderServiceFeignClient.orders();
        //return testFeignService.getTestFeign();
    }

    /**
     * 为了校验超时熔断
     * @return
     */
    @PostMapping("/getTestFeignHystrixController")
    public String getTestFeignHystrixController(){
        return testFeignFallBackService.getTestFeign();
    }


    /**
     * 为了校验资源熔断-信号量熔断
     * @return
     */
    @PostMapping("/getResource")
    public String getResource(){
         resourceTriggeredHystrixService.getResource();
         return "资源熔断-信号量熔断";
    }

    /**
     * 为了校验资源熔断-线程池熔断
     * @return
     */
    @PostMapping("/insert")
    public String insert(String str){
        resourceTriggeredHystrixService.insert(str);
        return "资源熔断-线程池熔断";
    }


}
