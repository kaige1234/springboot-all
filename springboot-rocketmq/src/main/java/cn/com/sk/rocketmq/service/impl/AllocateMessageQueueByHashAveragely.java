/*package cn.com.sk.rocketmq.service.impl;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.MixAll;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sun.jvm.hotspot.utilities.MessageQueue;

import java.util.ArrayList;
import java.util.List;

*//**
 * @author sunkai
 * @title: AllocateMessageQueueByHashAveragely
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/9/719:01
 *//*
@Slf4j
@Component
public class AllocateMessageQueueByHashAveragely extends AllocateMessageQueueAveragely {

    public List<MessageQueue> allocate(String consumerGroup, String currentCID, List<MessageQueue> mqAll, List<String> cidAll) {
        List<MessageQueue> submq = new ArrayList<MessageQueue>();

        //consumer的排序后的
        int index = cidAll.indexOf(currentCID);
        //取模
        int mod = mqAll.size() % cidAll.size();
        //如果队列数小于消费者数量，则将分到队列数设置为1，如果余数大于当前消费者的index,则
        //能分到的队列数+1，否则就是平均值
        int averageSize =
                mqAll.size() <= cidAll.size() ? 1 : (mod > 0 && index < mod ? mqAll.size() / cidAll.size()
                        + 1 : mqAll.size() / cidAll.size());
        //consumer获取第一个MessageQueue的索引
        int startIndex = (mod > 0 && index < mod) ? index * averageSize : index * averageSize + mod;
        // 如果消费者大于队列数，rang会是负数，循环也就不会执行
        int range = Math.min(averageSize, mqAll.size() - startIndex);
        for (int i = 0; i < range; i++) {
            submq.add(mqAll.get((startIndex + i) % mqAll.size()));
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
}*/
