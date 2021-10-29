package cn.com.sk.javabasics.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/***
 * 案例：https://www.cnblogs.com/mr-yang-localhost/p/7812038.html
 * 官网：https://docs.jboss.org/hibernate/validator/4.2/reference/zh-CN/html_single/#validator-gettingstarted
 * 一个Field中可以有多个注解，根据情况而定；
 *     @Null 被注释的元素必须为 null
 *     @NotNull 被注释的元素必须不为 null
 *     @AssertTrue 被注释的元素必须为 true
 *     @AssertFalse 被注释的元素必须为 false
 *     @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 *     @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 *     @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 *     @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 *     @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 *     @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 *     @Past 被注释的元素必须是一个过去的日期
 *     @Future 被注释的元素必须是一个将来的日期
 *     @Pattern(regex=,flag=) 被注释的元素必须符合指定的正则表达式
 *     Hibernate Validator 附加的 constraint
 *     @NotBlank(message =)   验证字符串非null，且长度必须大于0
 *     @Email 被注释的元素必须是电子邮箱地址
 *     @Length(min=,max=) 被注释的字符串的大小必须在指定的范围内
 *     @NotEmpty 被注释的字符串的必须非空
 *     @Range(min=,max=,message=) 被注释的元素必须在合适的范围内
 */
@Data
public class VolidationEntity {

    @Null(message = "不能空")//int类型是存在默认值的
    private String id;
    @Length(min = 0,max = 3,message = "名字的长度太长了")
    @NotNull(message = "名字为空")//字段不存在
    private String name;

    @NotBlank(message = "编码字段为空")//NotBlank 不能为空指的是值不能为空
    private String code;
    @AssertTrue(message = "isFlag 错了")
    private boolean isFlag;
    @AssertFalse(message = "isUse 错了")
    private boolean isUse;
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确")
    private String  age;
    @Digits(integer = 1,fraction = 2,message = "怎么回事")
    private int oldAge;
    private int decimalMin;
    @Email(message = "不是email")
    private String emai;

    private int decimalMax;
    @NotEmpty(message = "notEtity不能为空")
    private String notEtity;
    @Size(min = 0,max = 3,message = "list 列表的长度太长了")
    private List<String> list;
    @Range(message = "超出了范围",min = 1,max = 10)
    private int num;

    @Future(message = "将来的某一一天" )
    private Date future;

    @Past(message = "过去的时间")
    private Date past;
}
