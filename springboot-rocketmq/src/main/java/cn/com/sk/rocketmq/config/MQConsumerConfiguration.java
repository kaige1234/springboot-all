package cn.com.sk.rocketmq.config;

import cn.com.sk.rocketmq.service.impl.AllocateMessageQueueByHashAveragely;
import cn.com.sk.rocketmq.service.impl.MQConsumeMsgListenerProcessor;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.aliyun.openservices.shade.org.apache.commons.lang3.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunkai
 * @title: MQConsumerConfiguration
 * @projectName youzhengxiangmu
 * @description: TODO
 * @date 2021/9/619:20
 */
@Configuration
@Slf4j
public class MQConsumerConfiguration {
    //@Value("${rocketmq.consumer.namesrvAddr}")
        @Value("192.168.211.147:9876")
    private String namesrvAddr;
    //@Value("${rocketmq.consumer.groupName}")
    @Value("ConsumerTest")
    private String groupName;
    //@Value("${rocketmq.consumer.consumeThreadMin}")
    @Value("20")
    private int consumeThreadMin;
    //@Value("${rocketmq.consumer.consumeThreadMax}")
    @Value("10")
    private int consumeThreadMax;
    //@Value("${rocketmq.consumer.topics}")
    @Value("TopicTest:anran-topic")
    //@Value("TopicTestss:anran-tosspic")
    private String topics;
    //@Value("${rocketmq.consumer.consumeMessageBatchMaxSize}")
    @Value("20")
    private int consumeMessageBatchMaxSize;
    @Autowired
    private MQConsumeMsgListenerProcessor mqMessageListenerProcessor;

    @Autowired
    private AllocateMessageQueueByHashAveragely allocateMessageQueueByHashAveragely;

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer() {
        if (StringUtils.isEmpty(groupName)){
        }
        if (StringUtils.isEmpty(namesrvAddr)){
        }
        if(StringUtils.isEmpty(topics)){
        }
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.registerMessageListener(mqMessageListenerProcessor);
        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        /**
         * 设置消费模型，集群还是广播，默认为集群
         */
        //consumer.setMessageModel(MessageModel.CLUSTERING);
        /**
         * 设置一次消费消息的条数，默认为1条
         */
        consumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);

        consumer.setAllocateMessageQueueStrategy(allocateMessageQueueByHashAveragely);
        try {
            /**
             * 设置该消费者订阅的主题和tag，如果是订阅该主题下的所有tag，则tag使用*；如果需要指定订阅该主题下的某些tag，则使用||分割，例如tag1||tag2||tag3
             */
            String[] topicTagsArr = topics.split(";");
            for (String topicTags : topicTagsArr) {
                String[] topicTag = topicTags.split(":");
                consumer.subscribe(topicTag[0],topicTag[1]);
            }
            consumer.start();
            log.info("consumer is start !!! groupName:{},topics:{},namesrvAddr:{}",groupName,topics,namesrvAddr);
        }catch (MQClientException e){
            log.error("consumer is start !!! groupName:{},topics:{},namesrvAddr:{}",groupName,topics,namesrvAddr,e);
        }
        return consumer;
    }
}
