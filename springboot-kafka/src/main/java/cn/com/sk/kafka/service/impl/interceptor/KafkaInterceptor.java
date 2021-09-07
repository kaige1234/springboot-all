package cn.com.sk.kafka.service.impl.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author sunkai
 * @title: KafkaInterceptor
 * @projectName springboot-all
 * @description: 写好了配置文件后，需要在配置拦截器的配置
 * @date 2021/8/210:02
 */

public class KafkaInterceptor implements ProducerInterceptor<String,String> {
    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        System.out.println("发送消息时先进入拦截器，再发送消息");
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        System.out.println("收到消息，进行ack");
    }

    @Override
    public void close() {
        System.out.println("关闭消息");
    }

    @Override
    public void configure(Map<String, ?> configs) {
        System.out.println("进行ack的确认");
    }
}
