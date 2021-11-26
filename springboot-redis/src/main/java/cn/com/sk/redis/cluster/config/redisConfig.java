package cn.com.sk.redis.cluster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;


@Configuration
public class redisConfig {




/*
    public static void main(String[] args) throws IOException {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMinIdle(5);

        Set<HostAndPort> set = new HashSet<HostAndPort>();
        set.add(new HostAndPort("192.168.1.8",8001));
        set.add(new HostAndPort("192.168.1.8",8002));
        set.add(new HostAndPort("192.168.1.7",8001));
        set.add(new HostAndPort("192.168.1.7",8002));
        set.add(new HostAndPort("192.168.1.11",8001));
        set.add(new HostAndPort("192.168.1.11",8002));
        JedisCluster jedisCluster = null;

        try {
            jedisCluster = new JedisCluster(set,6000,5000,10,jedisPoolConfig);
           System.out.println(jedisCluster.set("test:sunkai","测试的"));
            System.out.println(jedisCluster.get("test:sunkai"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedisCluster != null ){
                jedisCluster.close();
            }
        }



    }*/
}
