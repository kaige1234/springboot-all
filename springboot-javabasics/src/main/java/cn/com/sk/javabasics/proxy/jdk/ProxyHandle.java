package cn.com.sk.javabasics.proxy.jdk;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;

public class ProxyHandle implements InvocationHandler {

    private PesonInterface pesonInterface;

    ProxyHandle(PesonInterface pesonInterface){
        this.pesonInterface = pesonInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(pesonInterface, args);
        return invoke;
    }
}
