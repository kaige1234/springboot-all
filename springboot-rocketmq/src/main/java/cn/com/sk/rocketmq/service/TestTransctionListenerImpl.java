package cn.com.sk.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class TestTransctionListenerImpl implements TransactionListener {


    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendMsg(String msg){
        Message message = new Message();
        message.setBody("你好帅".getBytes());
        rocketMQTemplate.convertAndSend("test_topic_test1",msg);
    }


    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        log.info("提交事物");
        return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        log.info("回滚事物");
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
