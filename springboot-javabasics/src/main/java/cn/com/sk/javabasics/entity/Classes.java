package cn.com.sk.javabasics.entity;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Data
public class Classes {
    @NotBlank(message = "编码为空")
    private String code;
    @Valid
    private List<Student> list ;
}
