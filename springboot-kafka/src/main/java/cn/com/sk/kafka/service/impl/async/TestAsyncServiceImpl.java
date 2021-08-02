package cn.com.sk.kafka.service.impl.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sunkai
 * @title: TestAsyncServiceImpl
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/214:40
 */
@Service
public class TestAsyncServiceImpl implements TestAsyncService {

    @Autowired
   private TestAsync2Service testAsync2Service;

    @Override
    public void testAsync() {
        System.out.println("方法被调用");
        /*new Thread(){
            @Override
            public void run(){
                TestAsyncServiceImpl testAsyncService = new TestAsyncServiceImpl();
                testAsyncService.test();
            }
        }.start();*/
        testAsync2Service.get();
        System.out.println("方法调用完成");
    }

    @Override
    @Async
    public void test() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("方法异步调用");
    }
}
