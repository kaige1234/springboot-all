package cn.com.sk.lamd.defaultinerface.lamd;

import cn.com.sk.lamd.defaultinerface.entity.User;
import cn.com.sk.lamd.defaultinerface.util.Utils;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//https://www.cnblogs.com/haixiang/p/14291626.html
public class CreateList {

    public static void main(String[] args){
        List<User> userList = Utils.getRepetitionUserList();
        //第一种使用方式为对这个对象中的属性进行出来
        List<User> collect = userList.stream().peek(user -> user.setCode(user.getCode() + "G")).collect(Collectors.toList());
        //第二种操作是在每次流中进行打印调试
        List<User> collect1 = userList.stream().peek(System.out::println).collect(Collectors.toList());
        System.out.println("");

    }

    public static void flatMap(){
        List<User> userList = Utils.getRepetitionUserList();
        List<String> collect = userList.stream().map(User::getCode).map(s -> s.split(",")).flatMap(Arrays::stream).collect(Collectors.toList());
        String[] strArr = {"Hello","Work","She"};
        String[] strAr = {"Here"};
        List<String[]> collect1 = Stream.of(strAr, strArr).collect(Collectors.toList());
        List<String> collect2 = Stream.of(strAr, strArr).flatMap(Arrays::stream).collect(Collectors.toList());
        List<String> e = Stream.of(strAr, strArr).flatMap(s -> Arrays.stream(s).filter(a -> a.equals("She"))).collect(Collectors.toList());
        System.out.println("");
    }

    /**
     * 将字符串拼接起来
     */
    public static void joining(){
        List<User> userList = Utils.getRepetitionUserList();
        //字符串拼接，delimiter:分隔符  prefix:参数前缀   suffix:参数后缀
        String collect = userList.stream().map(User::getUserName).collect(Collectors.joining(",", "1", "2"));
        //将字符串拼接在一起
        String collect1 = userList.stream().map(User::getCode).collect(Collectors.joining());
        //将字符串连接起来，通过逗号分割
        String collect2 = userList.stream().map(User::getUserName).collect(Collectors.joining(","));
        System.out.println("");
    }

    /**
     * 分组
     */
    public static void  groupBy(){
        List<User> userList = Utils.getRepetitionUserList();
        //第一中 根据某个字段进行分组
        Map<String, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getCode));
        //第二中使用方式
        Map<String, Set<User>> collect1 = userList.stream().collect(Collectors.groupingBy(User::getCode, Collectors.toSet()));
        Map<String, Map<String, String>> collect2 = userList.stream().collect(Collectors.groupingBy(User::getCode, Collectors.toMap(User::getCode, User::getUserName,(o1,o2)->o1)));
        //第三中
        HashMap<String, List<User>> collect3 = userList.stream().collect(Collectors.groupingBy(User::getCode, HashMap::new, Collectors.toList()));
        //将map中的集合进行抽离出来
        List<User> collect4 = collect3.values().stream().flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println("");
    }

    /**
     * 去掉重复的
     */
    public static void distinct(){
        /**
         * distinct可以多对象进行去重复，对象是属性值都是一样的才能就行去重复，不然不行
         */
        List<User> userList = Utils.getRepetitionUserList();
        List<User> collect1 = userList.stream().distinct().collect(Collectors.toList());
        List<String> collect = userList.stream().map(User::getCode).distinct().collect(Collectors.toList());
        System.out.println("");
    }

    /**
     * 统计数量
     */
    public static void count(){
        List<User> userList = Utils.getUserList();
        long count = userList.stream().count();
        System.out.println();
    }

    /**
     * 将list 转换成set
     */
    public static void toSet(){
        List<User> userList = Utils.getRepetitionUserList();
        //将list转化成set  该功能用来去重
        Set<User> collect = userList.stream().collect(Collectors.toSet());
        System.out.println("");
    }

    /**
     * 将list转换成map
     */
    public static void toMap(){
        List<User> userList = Utils.getUserFor();
        //将list 转换成map  如果key重复会报错
        Map<String, String> collect = userList.stream().collect(Collectors.toMap(User::getCode, User::getUserName));
        //将list 装欢成map 如果key重复 按照第一个选择
        HashMap<String, User> collect1 = userList.stream().collect(Collectors.toMap(User::getCode, user -> user, (o1, o2) -> o1, HashMap::new));
        //将list 转换成treemap 如果key重复按照第一个选择
        TreeMap<String, User> collect2 = userList.stream().collect(Collectors.toMap(User::getCode, o -> o, (o1, o2) -> o1, TreeMap::new));
        //将list 转换成ConcurrentHashMap
        ConcurrentMap<String, User> collect3 = userList.stream().collect(Collectors.toConcurrentMap(User::getCode, o -> o, (o1, o2) -> o1));
        System.out.println("");
    }

    /**
     * 将数组和集合转合成list的集中操作
     */
    public static void testCreateList(){
        List<User> userList = Utils.getUserList();
        //第一种创建集合
        Stream<User> stream = userList.stream();

        //第二种创建集合
        List<String> strList = Stream.of("2","44","54").collect(Collectors.toList());

        //第三种创建集合
        String[] strArr = {"aad","rr","bb","ee"};
        Stream<String> stream1 = Arrays.stream(strArr);
    }

}
