package cn.com.sk.javabasics.threadtest;

import java.util.concurrent.locks.LockSupport;

/**
 * @author sunkai
 * @title: LockSupport
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1317:35
 */
public class LockSupportTest {
    public static class LockSupportThread extends Thread{

        @Override
        public void run() {
            System.out.println("开始");
            LockSupport.park(this);
            System.out.println("结束");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        LockSupportThread lockSupportThread = new LockSupportThread();
        lockSupportThread.start();
        System.out.println("线程运行");
        Thread.sleep(1000);
        LockSupport.unpark(lockSupportThread);
        System.out.println("线程运行结束");
    }



}
