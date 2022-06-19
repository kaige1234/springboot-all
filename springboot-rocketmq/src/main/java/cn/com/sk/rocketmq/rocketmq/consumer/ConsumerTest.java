package cn.com.sk.rocketmq.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerTest {
    public static void main(String[] args) throws MQClientException {
        // 1.创建消费者consumer，指定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_topic_test1");
        // 2.指定Nameserver地址
        consumer.setNamesrvAddr("192.168.1.9:9876");
        // 设置超时
        consumer.setConsumeTimeout(15000);
        // 3.订阅主题topic和tag
        consumer.subscribe("test-rocket-mq", "tag1");
        // 设置消费模式：负载均衡和广播模式,默认负载均衡模式-MessageModel.CLUSTERING ,广播模式-MessageModel.BROADCASTING
        consumer.setMessageModel(MessageModel.BROADCASTING);
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        // 4.设置回调函数,处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            // 接收消息内容
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgList, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg:msgList) {
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 5.启动消费者consumer
        consumer.start();
    }

}
