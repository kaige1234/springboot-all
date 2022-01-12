package cn.com.sk.quartz.service.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MySchedule {


    public static void main(String[] args) throws SchedulerException {
        //用来传数据的对象
        JobDetail jobDetail = JobBuilder.newJob(MyQuartz.class)
                .withIdentity("group_01")
                .usingJobData("dataKey","value")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("group_01")
                .startNow()
                //定义规则
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever()
                )
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();

        scheduler.scheduleJob(jobDetail,trigger);

        scheduler.start();
    }
}
