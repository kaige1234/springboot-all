package cn.com.sk.javabasics.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sunkai
 * @title: AsyncTestService
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/2/2110:45
 */
@Service
@Slf4j
public class AsyncTestService {


    public void getSyTestService(){
        log.info("正常逻辑处理");
    }

    /**
     * async 自定义
     */
    @Async("queryIndicatorsExecutor")
    public void difinationAsyncTestService(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理异步消息");
    }

    /**
     * async 默认使用
     */
    @Async()
    public void getAsyncTestService(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理异步消息");
    }
}
