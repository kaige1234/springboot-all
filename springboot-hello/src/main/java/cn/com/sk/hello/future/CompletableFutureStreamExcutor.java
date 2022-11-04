package cn.com.sk.hello.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureStreamExcutor {
    public static Integer Ince(Integer para){
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        return para * para;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> completableFuture =
                CompletableFuture.supplyAsync(()->Ince(50),executorService)
                .thenApply((i)->Integer.toString(i))
                .thenApply((str)->"\""+str+"\"")
                .thenAccept(System.out::println);
        //completableFuture.get();
    }
}
