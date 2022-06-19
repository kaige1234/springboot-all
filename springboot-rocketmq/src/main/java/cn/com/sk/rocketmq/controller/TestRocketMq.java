package cn.com.sk.rocketmq.controller;

import cn.com.sk.rocketmq.service.TestTransctionListenerImpl;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testRocketMq")
@Slf4j
public class TestRocketMq {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Autowired
    private TestTransctionListenerImpl testTransctionListener;


    @RequestMapping("/testTransction")
    public void testTransction(){

        log.info("操作数据库事物");
        Message message = new Message();
        byte[] bytes = "shiwucaozuo".getBytes();
        message.setBody(bytes);
        testTransctionListener.executeLocalTransaction(message,1);

    }

    @RequestMapping("/sendMsg")
    public void sendMsg(){
        testTransctionListener.sendMsg("ssss");
    }
}
