package cn.com.sk.hello.controller;

import cn.com.sk.hello.service.ImportTestClass;
import cn.com.sk.hello.service.TestErrorService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/cooperatives")
public class TestController {

    @Autowired
    private TestErrorService testErrorService;

    @Autowired
    private ImportTestClass importTestClass;

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

    @GetMapping("/importTestClass")
    public void importTestClass(){
        importTestClass.get();
    }

    @GetMapping("/get")
    public Result get(){
        System.out.println("/cooperatives/get");
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

    @GetMapping("/getError")
    public void getError(){
        testErrorService.getError();
    }

    @GetMapping("/testJmeter")
    public String testJmeter(String name){
        System.out.println("调用jmeter成功："+name);
        return "sucesscess";
    }

    @GetMapping("/testJmeterNotParame")
    public String testJmeterNotParame(){
        System.out.println("调用jmeter成功：testJmeterNotParame");
        return "testJmeterNotParame -> suceess";
    }

}
