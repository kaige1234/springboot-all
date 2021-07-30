package cn.com.sk.kafka.service.impl.kafkaspringboot;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author sunkai
 * @title: ConsumerListener
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/7/2920:13
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "test" ,groupId = "springboottopic-consumer")
    public void onMessage(String message){
        System.out.println("收到消息:"+message);
    }
}
