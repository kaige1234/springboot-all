package cn.com.sk.lamd.controller;

import com.sun.org.apache.xml.internal.utils.StringVector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TestController {
    private static  final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args){
        /*List<String> list =  new ArrayList<String>();
        list.add("1");
        list.add("1");
        list.add("3");
        list.add("4");
        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(String::hashCode, str->str));
        System.out.println(collect);*/

        /*Map<String,String> map = new HashMap<>();
        map.put("String_01","String_01");
        map.put("String_02","String_02");
        map.put("String_03","String_03");
        map.put("String_04","String_04");
        List<String> collect = map.values().stream().collect(Collectors.toList());
        System.out.println(collect.size());*/

        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("string","string");

        TestController.tableSizeFor(4);

//
//
//
//        System.out.println(MAXIMUM_CAPACITY);
//
//        //System.out.println("ddd:"+(MAXIMUM_CAPACITY >>> 1));
//        int initialCapacity= 23;
//        int cap = ((initialCapacity >= (MAXIMUM_CAPACITY >>> 1)) ?
//                MAXIMUM_CAPACITY :
//                tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
//
//        System.out.println("cap:"+cap);
    }

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


}
