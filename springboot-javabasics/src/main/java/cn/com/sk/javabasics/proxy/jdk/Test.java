package cn.com.sk.javabasics.proxy.jdk;

public class Test {

    public static void main(String[] args){
        ProxyClass proxyClass = new ProxyClass(new IPeson());
        PesonInterface iPeson = (PesonInterface)proxyClass.getInstance();
        iPeson.get();
    }
}
