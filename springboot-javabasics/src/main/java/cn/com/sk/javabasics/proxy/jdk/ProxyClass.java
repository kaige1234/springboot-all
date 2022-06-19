package cn.com.sk.javabasics.proxy.jdk;


import java.lang.reflect.Proxy;

public class ProxyClass {

    private PesonInterface pesonInterface;

    ProxyClass(PesonInterface pesonInterface ){
        this.pesonInterface = pesonInterface;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(pesonInterface.getClass().getClassLoader(),
                pesonInterface.getClass().getInterfaces(),
               new ProxyHandle(pesonInterface));
    }


}
