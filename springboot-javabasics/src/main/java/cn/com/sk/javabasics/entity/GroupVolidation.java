package cn.com.sk.javabasics.entity;

import cn.com.sk.javabasics.annotation.CannotHaveBlank;
import cn.com.sk.javabasics.annotation.CustomValidation;
import cn.com.sk.javabasics.group.OneGroup;
import cn.com.sk.javabasics.group.TwoGroup;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@CannotHaveBlank(message = "GroupVolidation报错了",groups = {OneGroup.class})
public class GroupVolidation {


    @NotBlank(groups = OneGroup.class,message = "组一的名字为空")
    private  String name;

    @NotBlank(groups = TwoGroup.class,message = "组二的编号为空")
    private String code;

    @NotBlank(groups = {TwoGroup.class,OneGroup.class},message = "组二和组一的编号为空")
    private String num;
}
