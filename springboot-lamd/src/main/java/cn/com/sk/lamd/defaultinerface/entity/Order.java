package cn.com.sk.lamd.defaultinerface.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author sunkai
 * @title: Order
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2916:33
 */
@Data
public class Order {
    private Long orderId;
    private String orderName;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
