package cn.com.sk.lamd.defaultinerface.entity;

import lombok.Data;

/**
 * @author sunkai
 * @title: User
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2916:33
 */

@Data
public class User {
    private Long uid;
    private String userName;
    private String code;
    private Integer status;
}
