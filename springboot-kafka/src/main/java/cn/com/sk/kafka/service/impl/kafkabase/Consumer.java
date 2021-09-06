package cn.com.sk.kafka.service.impl.kafkabase;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author sunkai
 * @title: Consumer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/7/2919:16
 */
public class    Consumer extends Thread {

    private final KafkaConsumer<Integer,String> kafkaConsumer;
    private final String topic;

    public Consumer(String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","192.168.211.147:9092,192.168.211.148:9092,192.168.211.128:9092");
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer",StringDeserializer.class.getName());
        properties.put("group.id","group-test");
        this.kafkaConsumer = new KafkaConsumer<Integer, String>(properties);
        this.topic = topic;
    }


    @Override
    public void run() {
            kafkaConsumer.subscribe(Arrays.asList("test"));
       while(true){
           ConsumerRecords<Integer, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
           for(ConsumerRecord<Integer,String> record:records){
               StringBuffer sb = new StringBuffer();
               sb.append("主题："+record.topic());
               sb.append("偏移量："+record.offset());
               sb.append("信息的key："+record.key());
               sb.append("信息的value："+record.value());
               System.out.println(sb.toString());
           }
       }
    }

    public static void main(String[] args){
        Consumer consumer = new Consumer("test");
        consumer.start();
    }
}
