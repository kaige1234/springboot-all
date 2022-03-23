package cn.com.sk.annotation.controll;

import cn.com.sk.annotation.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Test test;
}
