package cn.com.sunkai.ribbon.springbootspringcloudribbontwo.controller;

import cn.com.sunkai.ribbon.springbootspringcloudribbontwo.entity.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getTest")
    public String getTest(){
        System.out.println("nihao");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "服务调用成功";
    }

    @RequestMapping("/getOkHttp")
    public String getOkHttp(final MessageDTO messageDTO, HttpServletRequest request){
        System.out.println("接收到的数据为：{}"+messageDTO.getLogistics_interface());
        return "99000002|0|HE/i4DdBIo1NmDjhu028KmoTlQtIV8SH8DanJyGnPkpdTrfbSr28VhsmU6EIdBuvFBvRnNUz4V81ZSggF4oxsxGtjwMD3szpfJwM/E6Iybkuasd75iVcK1pWSSB70/uy8D4jCbnImHMcbJeDxLMchs/12emxTwJPcvL6NXDgEkY5xuUr9Ktl/F3Fkns0M8Suai7BP0iQpciHANKqBP76Q9yv1d52XyuTGQKdTlB21J6PxAZDbYp5RYjyhQUS1k6Z|ZmMyYjBiMmZiMmNiMmRjMmVjMzFlNTg4Zjk2NjQzNDM=";
    }
}
