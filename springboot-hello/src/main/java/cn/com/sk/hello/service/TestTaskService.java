package cn.com.sk.hello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class TestTaskService {

    @Autowired
    private TestService testService;

    public String getUserName(){
        log.info("getUserName 中的 info");
        log.debug("getUserName 中的 debug");
        log.error("getUserName 中的 error");
        log.info("测试热部署文件");
        testService.excuMethod();
        return "seccess";
    }
}
