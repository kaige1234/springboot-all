package cn.com.sk.lamd.defaultinerface.util;

import cn.com.sk.lamd.defaultinerface.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunkai
 * @title: Utils
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2916:32
 */
public class Utils {

    public static User getUser(){
        User user = new User();
        user.setCode("1000");
        user.setStatus(1);
        user.setUid(122L);
        user.setUserName("李先生");
        return user;
    }

    public static List<User> getRepetitionUserList(){
        User user = new User();
        user.setCode("1000");
        user.setStatus(1);
        user.setUid(122L);
        user.setUserName("李先生");

        User user1 = new User();
        user1.setCode("1000");
        user1.setStatus(1);
        user1.setUid(122L);
        user1.setUserName("李先生");

        User user2 = new User();
        user2.setCode("1100");
        user2.setStatus(2);
        user2.setUid(122L);
        user2.setUserName("王先生");

        User user3 = new User();
        user3.setCode("1100");
        user3.setStatus(2);
        user3.setUid(122L);
        user3.setUserName("王小姐");
        return Arrays.asList(user,user1,user2,user3);
    }

    public static List<User> getUserList(){
        User user = new User();
        user.setCode("1300");
        user.setStatus(1);
        user.setUid(122L);
        user.setUserName("李先生");

        User user1 = new User();
        user1.setCode("1000");
        user1.setStatus(1);
        user1.setUid(122L);
        user1.setUserName("高先生");

        User user2 = new User();
        user2.setCode("1100");
        user2.setStatus(2);
        user2.setUid(122L);
        user2.setUserName("王先生");

        User user3 = new User();
        user3.setCode("1200");
        user3.setStatus(2);
        user3.setUid(122L);
        user3.setUserName("王小姐");
        return Arrays.asList(user,user1,user2,user3);
    }


    public static List<User> getUserFor(){
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
