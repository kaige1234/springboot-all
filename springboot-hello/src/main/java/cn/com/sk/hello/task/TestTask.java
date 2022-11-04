package cn.com.sk.hello.task;

import cn.com.sk.hello.service.TestTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class TestTask {
    @Autowired
    private TestTaskService testTaskService;

   //@Scheduled(cron = "0/5 * * * * ?")
    public void getNameTask(){
        testTaskService.getUserName();
    }

}
