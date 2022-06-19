package cn.com.sk.hello.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureStream {

    public static Integer calc(Integer para){
        try{
            Thread.sleep(5000);
        }catch (Exception e){


        }
        return para*para;
    }




    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture =
                CompletableFuture.supplyAsync(()->calc(50))
                        .thenApply((i)->Integer.toString(i))
                //.thenApply((str)->"\""+str+"\"")
        .thenAccept(System.out::println);
        completableFuture.get();
    }


}
