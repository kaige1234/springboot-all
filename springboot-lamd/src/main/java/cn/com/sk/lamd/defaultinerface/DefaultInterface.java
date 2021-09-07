package cn.com.sk.lamd.defaultinerface;

/**
 * @author sunkai
 * @title: DefaultInterface
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/8/515:53
 */
public interface DefaultInterface {

    int get();

    default  int defaultGet(){
        System.out.println("接口中的默认方法");
        return 1;
    }



}
