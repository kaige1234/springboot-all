package cn.com.sk.rocketmq.service.impl;

import cn.com.sk.rocketmq.entity.SecStaff;
import cn.com.sk.rocketmq.pojo.StaffDto;
import cn.com.sk.rocketmq.rocketmq.ResponseMsg;
import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageQueue;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.exception.RemotingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunkai
 * @title: MQProductService
 * @projectName youzhengxiangmu
 * @description: TODO
 * @date 2021/9/711:01
 */
@Service
@Slf4j
public class MQProductService {
    /**使用RocketMq的生产者*/
    private final DefaultMQProducer defaultMQProducer;
    @Value("TopicTest")
    private  String topic;
    @Value("anran-topic")
    private  String tag;

    public MQProductService(DefaultMQProducer defaultMQProducer) {
        this.defaultMQProducer = defaultMQProducer;
    }


    public void send(SecStaff secStaff, String method, String type) throws MQClientException, RemotingException, MQBrokerException, InterruptedException{
        StaffDto staffDto = new StaffDto();
        staffDto.setIdentityNumber("1".equals(secStaff.getCardTypeId())? secStaff.getCardNo():"");
        staffDto.setMethod(method);
        staffDto.setMobile(secStaff.getMobileNo());
        staffDto.setName(secStaff.getStaffName());
        staffDto.setOrganizeCode(secStaff.getOrganizeCode());
        staffDto.setOrganizeId("10987");
        staffDto.setOrganizeName("34564");
        staffDto.setStaffCode(secStaff.getStaffCode());
        String staffId = secStaff.getStaffId() != null  ? String.valueOf(secStaff.getStaffId()):"";
        staffDto.setStaffId(staffId);
        staffDto.setType(type);
        String strStaff = JSON.toJSONString(staffDto);
        Message sendMsg = new Message(topic,tag,strStaff.getBytes());
        defaultMQProducer.send(sendMsg,new SendCallbackListener(staffId),defaultMQProducer.getSendMsgTimeout());

        /*defaultMQProducer.send(sendMsg,new MessageQueueSelector(){

            @Override
            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                return mqs.get(0);
            }
        },defaultMQProducer.getSendMsgTimeout());*/
    }

    private enum MethodEnum{
        //I：insert U：update D：delete
        insert("I","增加"),
        update("U","更改"),
        delete("D","删除");
        private String code;
        private String name;

        MethodEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    private enum TypeEnum{

        staff("staff","员工信息"),
        farmers("farmers","农户信息"),
        cooperative("cooperative","合作社");
        private String code;
        private String name;

        TypeEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
