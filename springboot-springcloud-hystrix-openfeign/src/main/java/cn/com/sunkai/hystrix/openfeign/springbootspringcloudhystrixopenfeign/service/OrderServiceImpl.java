package cn.com.sunkai.hystrix.openfeign.springbootspringcloudhystrixopenfeign.service;

import org.springframework.web.bind.annotation.RestController;

/**
 * feign 的实现类接口，也就是在order中的业务处理的接口
 */
@RestController
public class OrderServiceImpl implements OrderService{

    @Override
    public String orders() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Return All Orders";
    }

}
