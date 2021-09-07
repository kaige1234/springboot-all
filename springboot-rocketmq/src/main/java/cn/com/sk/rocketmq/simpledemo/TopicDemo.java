package cn.com.sk.rocketmq.simpledemo;


/*
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
*/

import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * @author sunkai
 * @title: TopicDemo
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/3019:19
 */
public class TopicDemo {
    public static void main(String[] args) throws Exception {
        //分组名haoke这个可以任意设置
        DefaultMQProducer producer = new DefaultMQProducer("haoke");

        //设置nameserver的地址
        producer.setNamesrvAddr("192.168.211.147:9876");

        //启动生产者
        producer.start();

        /**
         * 创建topic，参数分别是：borker的名称，topic的名称，queue的数量
         * broker要和虚拟机broker.conf配置文件中brokername的名字一致
         * newTopic的名字随便起，queueNum8的意思是新建的消息队列数为8个
         */
        producer.createTopic("TopicTest","topic",8);
        System.out.println("topic创建成功！");
        producer.shutdown();
    }

}
