package cn.com.sk.javabasics.thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements   Runnable  {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public  int a=0;


    @Override
    public void run(){
        for(int i=0 ;i<10;i++){
            a++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLock = new ReentrantLockTest();
        ReentrantLockTest reentrantLock1 = new ReentrantLockTest();
        Thread thread_01 = new Thread(reentrantLock);
        Thread thread_02 = new Thread(reentrantLock);
        thread_01.start();
        thread_02.start();
        thread_01.join();
        thread_02.join();
        System.out.println(reentrantLock1.a);
    }



}
