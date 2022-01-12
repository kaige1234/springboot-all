package cn.com.sk.javabasics.thread.semaphore;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new ThreadTestA());
        Thread threadB = new Thread(new ThreadTestB());
        threadA.start();
        threadB.start();

    }

    static class ThreadTestA implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            while(true){
                semaphoreA.acquire();
                System.out.println("ThreadTestA");
                semaphoreB.release();
            }

        }
    }

    static class ThreadTestB implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            while(true){
                semaphoreB.acquire();
                System.out.println("ThreadTestB");
                semaphoreA.release();
            }
        }
    }





}
