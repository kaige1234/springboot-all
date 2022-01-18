package cn.com.sk.javabasics.netty.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sunkai
 * @title: InvokerProtocol
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1710:22
 */
@Data
public class InvokerProtocol implements Serializable {
    private String className;
    private String methodName;
    private Class<?>[] params;
    private Object[] values;
}
