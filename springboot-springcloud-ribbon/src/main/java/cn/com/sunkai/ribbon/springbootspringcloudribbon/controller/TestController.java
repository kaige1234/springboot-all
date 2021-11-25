package cn.com.sunkai.ribbon.springbootspringcloudribbon.controller;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.BufferedSink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getTest")
    public String getTest(){
        log.info("9036");
        return restTemplate.getForObject("http://sping-ribbon-02:9034/test/getTest",String.class);
    }

    @RequestMapping("/getYouzheng")
    public String getYouzheng(String key1,String key2) {
        String pushFarmerUrl ="http://127.0.0.1:9034/test/getOkHttp";
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        Request request = new Request.Builder()
                .url(String.format(pushFarmerUrl))
                .post(RequestBody.create(mediaType, "logistics_interface=23232"))
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                }
               log.info(response.body().string());
            }
        });


        log.info("收到的数据：{}", key1);
        return "调用成功";
    }
}
