package cn.com.sk.rocketmq.rocketmq;

import cn.com.sk.rocketmq.rocketmq.ResponseMsg;
import cn.com.sk.rocketmq.rocketmq.produce.SendCallbackListener;
import com.aliyun.openservices.shade.com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.SendStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunkai
 * @title: MqMessageController
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/9/413:20
 */
@Slf4j
@RestController
@RequestMapping("/mqMessageController")
public class MqMessageController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    //@Value(value = "${rocketmq.producer.topic}:${rocketmq.producer.sync-tag}")
    @Value(value = "TopicTest:anran-topic")
    private String syncTag;

   // @Value(value = "${rocketmq.producer.topic}:${rocketmq.producer.async-tag}")
   @Value(value = "TopicTest:anran-async-tags")
    private String asyncag;

   /* @Value(value = "${rocketmq.producer.topic}:${rocketmq.producer.oneway-tag}")
    private String onewayTag;*/

    /**
     * rocketmq 同步消息
     *
     * @param id 消息
     * @return 结果
     */
    @RequestMapping("/pushMessage.action")
    public ResponseMsg pushMessage(@RequestParam("id") int id) {
        log.info("pushMessage start : " + id);
        // 构建消息
        String messageStr = "order id : " + id;
        Message<String> message = MessageBuilder.withPayload(messageStr)
                .setHeader(RocketMQHeaders.KEYS, null)
                .build();
        // 设置发送地和消息信息并发送同步消息
        SendResult sendResult = rocketMQTemplate.syncSend(syncTag, message);
        log.info("pushMessage finish : " + id + ", sendResult : " + JSONObject.toJSONString(sendResult));
        ResponseMsg msg = new ResponseMsg();
        // 解析发送结果
        if (sendResult.getSendStatus().name().equals(SendStatus.SEND_OK.name())) {
            msg.setSuccessData(sendResult.getMsgId() + " : " + sendResult.getSendStatus());
        }
        return msg;
    }

    /**
     * 发送异步消息
     *
     * @param id 消息
     * @return 结果
     */
    @RequestMapping("/pushAsyncMessage.action")
    public ResponseMsg pushAsyncMessage(@RequestParam("id") int id) {
        log.info("pushAsyncMessage start : " + id);
        // 构建消息
        String messageStr = "order id : " + id;
        Message<String> message = MessageBuilder.withPayload(messageStr)
                .setHeader(RocketMQHeaders.KEYS, id)
                .build();
        // 设置发送地和消息信息并发送异步消息
        rocketMQTemplate.asyncSend(asyncag, message, new SendCallbackListener(id));
        log.info("pushAsyncMessage finish : " + id);
        ResponseMsg msg = new ResponseMsg();
        msg.setSuccessData(null);
        return msg;
    }
}
