package cn.com.sk.javabasics.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Student {
    @NotNull(message = "不能为空")
    private int id;
    @NotBlank(message = "name 不能为空！")
    private String name;
    @NotBlank(message = "code 不能为空")
    private String code;
}
