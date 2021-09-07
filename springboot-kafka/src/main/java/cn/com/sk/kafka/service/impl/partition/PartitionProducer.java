package cn.com.sk.kafka.service.impl.partition;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

/**
 * @author sunkai
 * @title: PartitionProducer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/314:12
 */
public class PartitionProducer extends Thread{


    private String topic;
    private KafkaProducer<Integer,String> kafkaProducer;

    public PartitionProducer(String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("client.id","patition_client");
        properties.put("key.serializer","org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        this.topic = topic;
        this.kafkaProducer = new KafkaProducer<Integer, String>(properties);
    }

    @Override
    public void run() {
        int num = 0;
        String msg="patition_test";
        int partitionSize= kafkaProducer.partitionsFor(topic).size();
        System.out.println("partitionSize:"+partitionSize);
        while (true){
            int partition = new Random().nextInt(partitionSize);
            kafkaProducer.send(new ProducerRecord<Integer, String>(topic,partition,num,msg));
        }
    }

    public static void main(String[] args){
        PartitionProducer partitionProducer = new PartitionProducer("test");
        partitionProducer.start();
    }

}
