package cn.com.sk.hello.lishener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventLishener implements ApplicationListener<EventLishenerService>{





    @Override
    public void onApplicationEvent(EventLishenerService event) {
        System.out.println("调用了监听事件");
    }
}
