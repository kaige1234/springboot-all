package cn.com.sk.quartz.service.time;

import java.util.Timer;

/**
 * jdk自带的定时任务  timer是单线程的
 */
public class TestTime {

    public static void main(String[] args){
        Timer timer = new Timer();
        timer.schedule(new TestTimeTask(),5000,1000L);
    }
}
