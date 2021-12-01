package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service;

import org.springframework.stereotype.Service;

@Service
public class ITestFeignService  implements TestFeignService{
    @Override
    public String getTestFeign() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "调用正常的方法";
    }
}
