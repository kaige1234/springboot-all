package cn.com.sk.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

@RestController
@RequestMapping("/testStampedLock")
public class TestStampedLock {
    static Thread[] holdCpuThreads = new Thread[3];
    static final StampedLock lock = new StampedLock();


    @RequestMapping("/get")
    public String get() throws InterruptedException {
      new Thread (()->{
        long readLong = lock.writeLock();
          LockSupport.parkNanos(600000000000L);
          lock.unlockWrite(readLong);
      }).start();
      Thread.sleep(100);
      for(int i =0;i<3;++i){
          holdCpuThreads[i] = new Thread(new HoldCPUReadThread());
          holdCpuThreads[i].start();
      }
      Thread.sleep(10000);
      for(int i =0; i<3;++i){
          holdCpuThreads[i].interrupt();
      }

        return "调用成功";
    }

    private static class HoldCPUReadThread implements Runnable{
        public void run(){
            long lockr = lock.readLock();
            System.out.println(Thread.currentThread().getName()+"获取读锁");
            lock.unlockRead(lockr);
        }
    }
}
