package cn.com.sk.hello.future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest implements Runnable{
    CompletableFuture<Integer> completableFuture = null;

    CompletableFutureTest(CompletableFuture<Integer> completableFuture){
        this.completableFuture = completableFuture;
    }
    @Override
    public void run() {
        int myRe = 0;
        try{
            myRe = completableFuture.get() * completableFuture.get();
        }catch (Exception e){

        }
        System.out.println(myRe);
    }

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new CompletableFutureTest(future)).start();
        //Thread.sleep(5000);
        future.complete(60);
    }
}
