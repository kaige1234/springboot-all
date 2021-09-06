package cn.com.sk.rocketmq.rocketmq.produce;

import org.apache.rocketmq.client.producer.SendCallback;
import com.aliyun.openservices.shade.com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * @author sunkai
 * @title: SendCallbackListener
 * @projectName springboot-all
 * @description: rocketmq异步回调监听
 * @date 2021/9/413:10
 */
@Slf4j
public class SendCallbackListener implements SendCallback {


    private int id;

    public SendCallbackListener(int id) {
        this.id = id;
    }

    @Override
    public void onSuccess(SendResult sendResult) {
        log.info("CallBackListener on success : " + JSONObject.toJSONString(sendResult));
    }

    @Override
    public void onException(Throwable throwable) {
        log.error("CallBackListener on exception : ", throwable);
    }


}