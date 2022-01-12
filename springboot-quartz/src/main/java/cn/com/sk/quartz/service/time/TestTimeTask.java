package cn.com.sk.quartz.service.time;

import java.util.TimerTask;

public class TestTimeTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("定时任务");
    }
}
