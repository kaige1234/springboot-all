package cn.com.sk.lamd.defaultinerface;

/**
 * @author sunkai
 * @title: DefaultInterfaceImpl
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/515:55
 */
public class DefaultInterfaceImpl implements DefaultInterface {

    @Override
    public int get() {
        System.out.println("实现接口中的方法");
        return 0;
    }

    @Override
    public int defaultGet() {
        System.out.println("实现接口接口中的默认方法重写");
        return 0;
    }

    public static void main(String[] args){
        DefaultInterfaceImpl defaultInterface = new DefaultInterfaceImpl();
        defaultInterface.get();
        defaultInterface.defaultGet();
    }
}
