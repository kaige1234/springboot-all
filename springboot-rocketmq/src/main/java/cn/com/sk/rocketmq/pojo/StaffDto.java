package cn.com.sk.rocketmq.pojo;

import lombok.Data;

/**
 * @author sunkai
 * @title: StaffDto
 * @projectName youzhengxiangmu
 * @description: TODO
 * @date 2021/9/416:52
 */
@Data
public class StaffDto {
    private String staffId;
    private String identityNumber;
    private String staffCode;
    private String name;
    private String organizeId;
    private String organizeCode;
    private String organizeName;
    private String mobile;
    //I：insert U：update D：delete
    private String method;
    //staff：员工信息 farmers：农户信息  cooperative：合作社
    private String type;
}
