package cn.com.sk.hello.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @title: TestController
 * @projectName springboot-all
 * @description: 测试controller
 * @date 2021/1/199:34
 */
@RestController
public class TestController {
    @Data
    class DecpSpectacularsRedFlag{
        private Integer flagColor;
        private Integer demandLevel;
        private String levelId;
    }
    @Data
    class Result{


        private String errorCode;
        private String errorMsg;
        private Object data;
    }

    @GetMapping("/get")
    public Result get(){
        DecpSpectacularsRedFlag decpSpectacularsRedFlag = new DecpSpectacularsRedFlag();
        decpSpectacularsRedFlag.setDemandLevel(3);
        decpSpectacularsRedFlag.setFlagColor(1);
        decpSpectacularsRedFlag.setLevelId("xl2314324253453");
        Result result = new Result();
        result.setData(decpSpectacularsRedFlag);
        result.setErrorCode("200");
        result.setErrorMsg("222");
        return result;
    }

    @GetMapping("/headTest")
    public void headTest(){
        List<String> list = new ArrayList<String>();
        for(;;){
            list.add("ddd");
        }
    }





}
