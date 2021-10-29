package cn.com.sk.lamd.defaultinerface.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author sunkai
 * @title: OrderDatil
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2916:34
 */
@Data
public class OrderDetil {
    private Long detilId;
    private Long orderId;
    private Long uid;
    private String orderName;
    private Date createTime;
    private Date updateTime;
}
