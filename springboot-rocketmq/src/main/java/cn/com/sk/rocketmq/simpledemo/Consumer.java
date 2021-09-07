package cn.com.sk.rocketmq.simpledemo;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.PullResult;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageQueue;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.apache.tomcat.websocket.Constants.FOUND;

/**
 * @author sunkai
 * @title: Consumer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/519:26
 */
public class Consumer {
    private String namesrvAddr = "192.168.211.148:9876";

    private String TOPIC_TEST = "TopicTest";

    private String TAG_TEST = "TAG_TEST";

    //pull消费模式
    private DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("ConsumerTest");

    private static final Map<MessageQueue, Long> offseTable = new HashMap<MessageQueue, Long>();

    @PostConstruct
    public void start() {
        try {
            System.out.println("MQ：ConsumerPullTest");
            //设置nameserver地址
            consumer.setNamesrvAddr(namesrvAddr);
            //消费模式 集群消费
            consumer.setMessageModel(MessageModel.CLUSTERING);
            //启动消费
            consumer.start();

            consumeMessage();
            System.out.println("\n\t MQ：start  ConsumerTest is success ! \n\t"
                    + "    topic is " + TOPIC_TEST + "  \n\t"
                    + "    tag is " + TAG_TEST + " \n\t");
        } catch (MQClientException e) {
            System.out.println("MQ：start ConsumerTest is fail" + e.getResponseCode() + e.getErrorMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void consumeMessage() throws MQClientException {
        //根据topic查询queue
        Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues(TOPIC_TEST);
        for(MessageQueue mq : mqs) {
            System.out.printf("Consume from the queue: %s%n", mq);
            SINGLE_MQ:while (true) {
                try {
                    PullResult pullResult =
                            consumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 32);
                    putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            //如果找到
                            for(Message message : pullResult.getMsgFoundList()) {
                                System.out.println(new String(message.getBody()));
                            }
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case NO_NEW_MSG:
                            break SINGLE_MQ;
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void putMessageQueueOffset(MessageQueue mq, long offset) {
        offseTable.put(mq, offset);
    }

    private static long getMessageQueueOffset(MessageQueue mq) {
        Long offset = offseTable.get(mq);
        if (offset != null) {
            return offset;
        }
        return 0;

    }

    @PreDestroy
    public void stop() {
        if (consumer != null) {
            consumer.shutdown();
            System.out.println("MQ：stop ConsumerTest success! ");
        }
    }

    public static void main(String [] args) {
        Consumer consumerTest = new Consumer();
        consumerTest.start();
    }

}
