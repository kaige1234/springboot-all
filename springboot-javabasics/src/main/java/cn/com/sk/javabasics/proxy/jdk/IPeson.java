package cn.com.sk.javabasics.proxy.jdk;

public class IPeson implements PesonInterface{
    @Override
    public void get() {
        System.out.println("获取信息");
    }

    @Override
    public void set() {
        System.out.println("设置信息");
    }
}
