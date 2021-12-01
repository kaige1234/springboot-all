package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service;


import org.springframework.web.bind.annotation.PostMapping;

public interface TestFeignService {

    @PostMapping("/getTestFeign")
    public String getTestFeign();
}
