package cn.com.sk.hello.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureException {

    public static Integer Ince(Integer para){
        return para/0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture =
                CompletableFuture.supplyAsync(()->Ince(30))
                .exceptionally(ex ->{
                    System.out.println(ex.toString());
                            return 0;
                }
                )
                .thenApply((i)->Integer.toString(i))
                .thenApply((str)->"\""+str+"\"")
                .thenAccept(System.out::println);
        completableFuture.get();
    }

}
