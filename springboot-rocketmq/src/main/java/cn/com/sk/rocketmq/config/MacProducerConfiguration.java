package cn.com.sk.rocketmq.config;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.locks.ReentrantLock;


public class MacProducerConfiguration {


    public static void main (String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("test_topic_test1");
        producer.setNamesrvAddr("192.168.1.7:9876");
        producer.setSendMsgTimeout(5000);
        producer.start();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        for (int i= 0 ;i<10;i++){
            Message message = new Message("test_topic_test1", "tag1", "order188", "2222".getBytes());

            SendResult sendResult =producer.send(( message));
            System.out.println(sendResult);
        }


    }


}
