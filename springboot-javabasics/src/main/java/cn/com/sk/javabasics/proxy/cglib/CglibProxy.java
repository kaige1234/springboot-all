package cn.com.sk.javabasics.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib   动态代理
 */
public class CglibProxy implements MethodInterceptor {

    public Object newInstall(Object object){
        return Enhancer.create(object.getClass(),this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("动态代理");
        methodProxy.invokeSuper(o,objects);
        System.out.println("动态代理完成");
        return null;
    }
}
