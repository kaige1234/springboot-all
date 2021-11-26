package cn.com.sunkai.hystrix.springbootspringcloudhystrix.controller;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunkai
 * @title: TestController
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/2514:39
 */
@RestController
@RequestMapping("/testController")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 熔断触发降级
     * @param num
     * @return
     */
    @HystrixCommand(commandProperties={
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),//开启熔断
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),//最小的请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000"),//5秒的熔断时间
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50")//百分比 失败率超过50%
    },fallbackMethod="fallbackTest")
    @RequestMapping("/get/{num}")
    public String get(@PathVariable("num") Integer num){

        if(num%2 == 1){
            return "正常访问，正常返回";
        }

        return restTemplate.getForObject("http://sping-ribbon-02:9034/test/getTest",String.class);
    }

    /**
     * fallback 必须和上面配置的的降级的名称相同，并且参数相同
     * @param num
     * @return
     */
    public String fallbackTest(Integer num){
        return "进行了熔断，所以走到这里，系统繁忙";
    }


    /**
     * 请求超时触发降级
     * @param num
     * @return
     */
    @HystrixCommand(fallbackMethod = "queryMethodTimeOutFallback",commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    @RequestMapping("/queryMethodTimeOut/{num}")
    public String queryMethodTimeOut(@PathVariable("num") Integer num){
        return restTemplate.getForObject("http://sping-ribbon-02:9034/test/getTest",String.class);
    }

    public String queryMethodTimeOutFallback(Integer num){
        return "请求超时触发降级";
    }


}
