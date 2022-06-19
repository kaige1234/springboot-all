package cn.com.sk.hello.aspect;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface Handler {
}
