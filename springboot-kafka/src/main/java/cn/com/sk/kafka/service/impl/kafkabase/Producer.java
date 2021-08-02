package cn.com.sk.kafka.service.impl.kafkabase;

import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author sunkai
 * @title: KafkaProduce
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/7/2911:43
 */
public class Producer extends Thread {

    private final KafkaProducer<Integer,String> produce;
    private final String topic;
    private final Boolean isAsync;

    public Producer(String topic, Boolean isAsync) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("client.id","DemoProducer");
        properties.put("key.serializer","org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //多少条数据发送一次 默认16k
        properties.put("batch.size",21234);
        List<String> in = new ArrayList<String>();
        in.add("cn.com.sk.kafka.service.impl.interceptor.KafkaInterceptor");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,in);
        this.produce = new KafkaProducer<Integer, String>(properties);
        this.topic = topic;
        this.isAsync = isAsync;
    }


    @SneakyThrows
    @Override
    public void run() {
        int num =1;
        while(true && num<10){
            String msg = "ssss:"+num;
            if(isAsync){
                produce.send(new ProducerRecord<Integer,String>(topic,num,msg));
                new Callback(){

                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        System.out.println("ddd ");
                    }
                };
            }else{
                produce.send(new ProducerRecord<Integer,String>(topic,num,msg)).get();
            }
            num++;
        }

    }

    public static  void main(String[] args){
        Producer kafkaProduce = new Producer("test",true);
        kafkaProduce.start();
    }

}
