package cn.com.sk.hello.lishener;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Service;

@Service
public class EventLishenerService extends ApplicationEvent {


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public EventLishenerService(@Qualifier("requestMappingHandlerMapping") Object source) {
        super(source);
    }

    public void getEventLishenerController(){
        System.out.println("调用了方法");
        ApplicationEventMulticaster applicationEventMulticaster =
                new SimpleApplicationEventMulticaster();
        applicationEventMulticaster.addApplicationListener(new EventLishener());
        applicationEventMulticaster.multicastEvent(new EventLishenerService(applicationEventMulticaster));
    }
}
