package cn.com.sk.rocketmq.simpledemo;


/*
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.SendResult;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
*/

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author sunkai
 * @title: SyncProducer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/3019:22
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //分组名haoke这个可以任意设置
        DefaultMQProducer producer = new DefaultMQProducer("haoke");
        producer.setSendMsgTimeout(20000);
        //设置nameserver的地址
        producer.setNamesrvAddr("192.168.1.7:9876");

        //启动生产者
        producer.start();

        //发送消息
        String msg = "我的第一个消息!";
        Message message = new Message("TopicTest", "0", msg.getBytes("UTF-8"));
        SendResult sendResult = producer.send(message);
        System.out.println("消息id: " + sendResult.getMsgId());
        System.out.println("消息队列: " + sendResult.getMessageQueue());
        System.out.println("消息offset值: " + sendResult.getQueueOffset());
        System.out.println(sendResult);
        producer.shutdown();
    }
}
