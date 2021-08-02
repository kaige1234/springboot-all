package cn.com.sk.kafka.controller;

import cn.com.sk.kafka.service.impl.async.TestAsync2Service;
import cn.com.sk.kafka.service.impl.async.TestAsyncService;
import cn.com.sk.kafka.service.impl.kafkaspringboot.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunkai
 * @title: FristKafkaController
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/7/2820:56
 */
@RestController
@RequestMapping("/frist")
public class FristKafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private TestAsyncService testAsyncService;

    @Autowired
    private TestAsync2Service testAsync2Service;

    @GetMapping("/get")
    public void get(String str){
        kafkaProducer.send(str);
    }

    @GetMapping("/testAsync")
    public void testAsync(){
        testAsyncService.test();
        testAsyncService.testAsync();
        //testAsync2Service.get();
        System.out.println("完成");
    }
}
