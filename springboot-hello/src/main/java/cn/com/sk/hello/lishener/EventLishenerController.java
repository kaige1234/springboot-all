package cn.com.sk.hello.lishener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventLishenerController")
public class EventLishenerController {

    @Autowired
    private EventLishenerService eventListenerService;


    @RequestMapping("/testntLishener")
    public void getEventLishener(){
        eventListenerService.getEventLishenerController();
    }

}
