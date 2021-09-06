package cn.com.sk.rocketmq.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author sunkai
 * @title: Consumer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/9/413:31
 */
@Component
/*
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer.group}", topic = "${rocketmq.consumer.topic}",
        selectorExpression = "${rocketmq.consumer.tags}", messageModel = MessageModel.BROADCASTING)
*/

/*@RocketMQMessageListener(consumerGroup = "ConsumerTest", topic = "TopicTest",
        selectorExpression = "anran-async-tags", messageModel = MessageModel.BROADCASTING)
@Slf4j*/
public class ConsumerAync implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("接收到异步消息："+message);
    }
}
