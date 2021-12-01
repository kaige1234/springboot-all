package cn.com.sk.elasticsearch.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/getTest")
    public void getTest(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(;;){
            executorService.execute(()-> {
                log.info("线程名称：{},",executorService.toString());
            });
        }
    }
}
