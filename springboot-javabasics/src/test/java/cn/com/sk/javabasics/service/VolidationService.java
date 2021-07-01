package cn.com.sk.javabasics.service;

import cn.com.sk.javabasics.service.impl.VolidationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class VolidationService {

    @Autowired
    private VolidationServiceImpl volidationService;

    @Test
    void name() {
        volidationService.testVolidation();
    }
}
