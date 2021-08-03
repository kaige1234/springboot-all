package cn.com.sk.kafka.service.impl.partition;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author sunkai
 * @title: SimplePartitioner
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/314:43
 */
public class SimplePartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        System.out.println("自定义分区器");
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
