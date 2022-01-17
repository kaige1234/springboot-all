package cn.com.sk.javabasics.threadtest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunkai
 * @title: LocalThreadTest
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1317:15
 */
public class LocalThreadTest {
    public static ThreadLocal<String> localThread = new ThreadLocal();
    public static void main(String[] args){
        ReentrantLock reentrantLock = new ReentrantLock();
        localThread.set("");
    }
}
