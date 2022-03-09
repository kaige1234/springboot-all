package cn.com.sk.hello.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.log4j.Log4j;
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


<<<<<<< Updated upstream
   /* @GetMapping("/delCooperatives")
=======
    @GetMapping("/delCooperatives")
>>>>>>> Stashed changes
    public String delCooperatives( String parames) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(parames);
            if (!jsonObject.containsKey("cooperativesId")) {
                return new String ("参数错误");
            }

            Long cooperativesId = jsonObject.getLong("cooperativesId");
            String modifier = jsonObject.getString("modifier");
            String modifierName = jsonObject.getString("modifierName");

            System.out.println("cooperativesId="+cooperativesId
                    +"; modifier="+modifier
                    +"; modifierName="+modifierName);

            return JSON.toJSONString(parames);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
<<<<<<< Updated upstream
    }*/
=======
    }
>>>>>>> Stashed changes





}
