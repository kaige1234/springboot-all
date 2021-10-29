package cn.com.sk.javabasics.annotation;

import cn.com.sk.javabasics.service.impl.CustomValidationImpl;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD,FIELD,ANNOTATION_TYPE,CONSTRUCTOR,PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {CustomValidationImpl.class})
public @interface CustomValidation {

    String message() default "不能包含空格";

    Class<?>[] groups() default {};

}
