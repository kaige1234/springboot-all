package cn.com.sk.javabasics.async.controller;

import cn.com.sk.javabasics.async.service.AsyncTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunkai
 * @title: AsyncTestController
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/2/2110:42
 */
@RestController
@RequestMapping("/async/test")
@Slf4j
public class AsyncTestController {

    @Autowired
    private AsyncTestService asyncTestService;

    /**
     * 普通的调用
     */
    @RequestMapping(value = "/getAsyncTest",method = RequestMethod.GET)
    public void getAsyncTest(String name){
        log.info("主线程开始处理信息-{}",name);
        asyncTestService.getSyTestService();
        asyncTestService.getAsyncTestService();
        log.info("主线程结束处理信息");
    }

    /**
     * 自定义异步线程
     */
    @RequestMapping(value = "/difinationAsyncTest",method = RequestMethod.GET)
    public void difinationAsyncTest(){
        log.info("difinationAsyncTest -> 主线程开始处理信息");
        asyncTestService.getSyTestService();
        asyncTestService.difinationAsyncTestService();
        log.info("difinationAsyncTest ->主线程结束处理信息");
    }


}
