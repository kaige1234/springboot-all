package cn.com.sk.jdbc.mapstruct.entity.to.map.entity;

import lombok.Data;

@Data
public class Employee {

    private String id;
    private String name;
    private Department department;

}
