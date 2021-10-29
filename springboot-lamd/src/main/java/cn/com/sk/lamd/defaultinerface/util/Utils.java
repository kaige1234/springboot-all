package cn.com.sk.lamd.defaultinerface.util;

import cn.com.sk.lamd.defaultinerface.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunkai
 * @title: Utils
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2916:32
 */
public class Utils {


    public static List<User> getUser(){
        List<User> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            User user = new User();
            user.setCode("1000"+i);
            user.setStatus(i%2 == 1 ? 1:0);
            user.setUid(Long.valueOf(i));
            user.setUserName("李先生_"+i);
            list.add(user);
        }
        return list;
    }





}
