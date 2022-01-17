package cn.com.sk.javabasics.threadtest;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author sunkai
 * @title: CountTask
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1214:54
 */
public class CountTask extends RecursiveTask<Long> {
    private static int broad=1000;
    private long start ;
    private long end;
    CountTask(long start ,long end){
        this.start =start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0L;
        boolean pem = (end-start)<broad;
        if(pem){
            for(long i =start;i<end ;i++){
                    sum += i;
            }
        }else{
            long step = (start + end)/100;
            ArrayList<CountTask> arrayList = new ArrayList<CountTask>();
            long post =start;
            for(int i=0;i<100;i++){
                long lastOne = post + step;
                if(lastOne > end ){
                    lastOne = end;
                }
                CountTask countTask = new CountTask(post,lastOne);
                post += step + 1;
                arrayList.add(countTask);
                countTask.fork();
            }
            for(CountTask t:arrayList){
                sum +=t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0,20L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(countTask);
        try {
            long res = submit.get();
            System.out.println("nihao:"+res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
