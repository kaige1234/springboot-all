package cn.com.sk.javabasics.thread.reentrantlock;

import lombok.SneakyThrows;
import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockInterrupted implements Runnable{
    private ReentrantLock  reentrantLock_01 = new ReentrantLock();
    private ReentrantLock reentrantLock_02 = new ReentrantLock();
    private  int a=1;
    ReentrantLockInterrupted(int a){
        this.a = a;
    }
    @SneakyThrows
    @Override
    public void run() {
        try {
            if(a==1){
                reentrantLock_01.lockInterruptibly();
                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                reentrantLock_02.lockInterruptibly();
            }else{
                reentrantLock_02.lockInterruptibly();
                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                reentrantLock_01.lockInterruptibly();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(reentrantLock_01.isHeldByCurrentThread()){
                reentrantLock_01.unlock();
            }
            if(reentrantLock_02.isHeldByCurrentThread()){
                reentrantLock_02.unlock();
            }
        }
        System.out.println("线程退出");
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockInterrupted reentrantLockInterrupted1
                = new ReentrantLockInterrupted(1);

        ReentrantLockInterrupted reentrantLockInterrupted2
                = new ReentrantLockInterrupted(2);
        Thread thread1 =new Thread(reentrantLockInterrupted1);
        Thread thread2 = new Thread(reentrantLockInterrupted2);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();
    }
}
