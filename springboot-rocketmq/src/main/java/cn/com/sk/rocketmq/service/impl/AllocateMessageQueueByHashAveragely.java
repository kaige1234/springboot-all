package cn.com.sk.rocketmq.service.impl;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.MixAll;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunkai
 * @title: AllocateMessageQueueByHashAveragely
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/9/719:01
 */
@Slf4j
@Component
public class AllocateMessageQueueByHashAveragely extends AllocateMessageQueueAveragely {

    @Override
    public List<MessageQueue> allocate(String consumerGroup, String currentCID, List<MessageQueue> mqAll, List<String> cidAll) {
        //解析queue id
        //char idChar = consumerGroup.charAt(consumerGroup.length() - "ConsumerTest".length());
        //int id = Integer.parseInt(idChar+"");
        List<MessageQueue> submq = new ArrayList<MessageQueue>();
        //根据queue id分配相应的MessageQueue
        for(MessageQueue mq : mqAll) {
            if(mq.getQueueId() == 0 || mq.getTopic().startsWith(MixAll.RETRY_GROUP_TOPIC_PREFIX)) {
                submq.add(mq);
            }
        }
        if(submq.size() == 0) {
            log.warn("allocate err:"+consumerGroup+","+currentCID+","+cidAll+","+mqAll);
        }
        return super.allocate(consumerGroup, currentCID, submq, cidAll);

    }

    @Override
    public String getName() {
        return super.getName();
    }

    public static void main(String[] args){
        String consumerGroup ="ConsumerGroup03";
        char idChar = consumerGroup.charAt(consumerGroup.length() - "ConsumerGroup".length() - 1);
        int id = Integer.parseInt(idChar+"");
        System.out.println(id);
    }
}
