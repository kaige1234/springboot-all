package cn.com.sk.kafka.service.impl.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sunkai
 * @title: TestAsync2Service
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/219:34
 */
@Service
public class TestAsync2Service {

    @Async
    public void get(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("TestAsync2Service-get");
    }
}
