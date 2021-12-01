package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "test-feign",fallback = TestFeignFallBackService.ITestFeignFallBackService.class)
public interface TestFeignFallBackService extends TestFeignService{
    @Component
    class ITestFeignFallBackService implements TestFeignFallBackService {
        @Override
        public String getTestFeign() {
            return "调用到了，熔断";
        }
    }

    public static void main(String[] args){
        int a = 1;
        for(int i =0;i<10 ;i++){
            a = a++;
            System.out.println(a);
        }
        System.out.println(a);


    }

}
