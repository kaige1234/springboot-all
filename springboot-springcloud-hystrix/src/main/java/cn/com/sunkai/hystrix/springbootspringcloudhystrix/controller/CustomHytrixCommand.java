package cn.com.sunkai.hystrix.springbootspringcloudhystrix.controller;

import cn.com.sunkai.hystrix.springbootspringcloudhystrix.aspect.HystrixCommandCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customHytrixCommand")
public class CustomHytrixCommand {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommandCustom(timeout = 1000,callBack = "callBack")
    @RequestMapping("/exec")
    public String exec(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*try {
            return restTemplate.getForObject("http://sping-ribbon-02:9034/test/getTest",String.class);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        return "";
    }

    public String callBack(){
        return "熔断";
    }

}
