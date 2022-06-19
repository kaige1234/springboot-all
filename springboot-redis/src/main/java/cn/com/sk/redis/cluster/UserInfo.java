package cn.com.sk.redis.cluster;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private Long id;
    private String name;
    private String code;
}
