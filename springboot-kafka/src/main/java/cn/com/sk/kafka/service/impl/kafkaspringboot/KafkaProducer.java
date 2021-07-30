package cn.com.sk.kafka.service.impl.kafkaspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sunkai
 * @title: KafkaProducer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/7/3010:06
 */
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<Integer,String> kafkaTemplate;

    public String send(@RequestParam String msg){
        kafkaTemplate.send("test",msg);
        return "success";
    }
}
