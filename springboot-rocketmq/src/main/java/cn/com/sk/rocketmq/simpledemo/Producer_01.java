package cn.com.sk.rocketmq.simpledemo;


import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.SendResult;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.common.RemotingHelper;

/**
 * @author sunkai
 * @title: Producer_01
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/3011:51
 */
public class Producer_01 {
    //nameserver地址
    private String namesrvAddr = "192.168.211.147:9876";

    private final DefaultMQProducer producer = new DefaultMQProducer("ProducerTest");

    private String TOPIC_TEST = "TopicTest";

    private String TAG_TEST = "TAG_TEST";

    /**
     * 初始化
     */
    public void start() {
        try {
            System.out.println("MQ：启动ProducerTest生产者");
            producer.setNamesrvAddr(namesrvAddr);
           // producer.setSendMsgTimeout(35000);
            producer.setVipChannelEnabled(false);
            producer.start();
            //发送消息
            for(int i=0;i<100;i++) {
                sendMessage("hello mq" + i);
            }
        } catch (MQClientException e) {
            System.out.println("MQ：启动ProducerTest生产者失败：" + e.getResponseCode() + e.getErrorMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void sendMessage(String data) {
        System.out.println("MQ: 生产者发送消息 :{}" +  data);
        Message message = null;
        try {
            //转换成字符数组
            byte[] messageBody = data.getBytes(RemotingHelper.DEFAULT_CHARSET);
            //创建消息对象
            message = new Message(TOPIC_TEST, TAG_TEST, String.valueOf(System.currentTimeMillis()), messageBody);
            //同步发送消息
            SendResult sendResult = producer.send(message);
            //异步发送消息
            /*producer.send(message, new SendCallback() {
                public void onSuccess(SendResult sendResult) {
                    System.out.println("MQ: CouponProducer生产者发送消息" + sendResult);
                }

                public void onException(Throwable throwable) {
                    System.out.println(throwable.getMessage() +  throwable);
                }
            });*/
            //单向发送 只发送消息，不等待服务器响应，只发送请求不等待应答。
            //producer.sendOneway(message);
        } catch (Exception e) {
            if (message != null) {
                System.out.println("异常");
                System.out.println("producerGroup:ProducerTest,Message:{}" + JSON.toJSON(message));
            }
            System.out.println("MQ: CouponProducer error :" + e);
        }
    }

    /*@PreDestroy
    public void stop() {
        if (producer != null) {
           // producer.shutdown();
            System.out.println("MQ：关闭ProducerTest生产者");
        }
    }*/

    public static void main(String[] args) {
        Producer_01 producerTest = new Producer_01();
        producerTest.start();
    }

}
