package cn.com.sunkai.hystrix.springbootspringcloudhystrix.aspect;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface HystrixCommandCustom {

     int timeout() default 100;

     String callBack() default  "";

}
