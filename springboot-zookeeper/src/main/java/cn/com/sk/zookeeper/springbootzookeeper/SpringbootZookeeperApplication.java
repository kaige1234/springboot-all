package cn.com.sk.zookeeper.springbootzookeeper;

import org.apache.curator.utils.ZookeeperFactory;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.ZooKeeperServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootZookeeperApplication.class, args);


    }

    public void get() throws Exception{
        ZooKeeper zookeeper = new ZooKeeper("ddddd", 222,new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });

        zookeeper.getData("/sunkai", new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        }, new Stat());
    }



}
