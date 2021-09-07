package cn.com.sk.rocketmq.service.impl;

import cn.com.sk.rocketmq.entity.SecStaff;
import cn.com.sk.rocketmq.mapper.SecStaffMapper;
import cn.com.sk.rocketmq.pojo.StaffDto;
import cn.com.sk.rocketmq.rocketmq.ResponseMsg;
import cn.com.sk.rocketmq.rocketmq.produce.SendCallbackListener;
import cn.com.sk.rocketmq.service.ISecStaffService;
import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
@Service
@Slf4j
public class SecStaffServiceImpl extends ServiceImpl<SecStaffMapper, SecStaff> implements ISecStaffService {
    @Autowired
    private SecStaffMapper secStaffMapper;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private MQProductService mqProductService;

    @Value(value = "TopicTest:anran-topic")
    private String syncTag;

    @Value(value = "TopicTest:anran-async-tags")
    private String asyncag;


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


    private int data(SecStaff secStaff,String method,String type){
        StaffDto staffDto = new StaffDto();
        staffDto.setIdentityNumber("1".equals(secStaff.getCardTypeId())? secStaff.getCardNo():"");
        staffDto.setMethod(method);
        staffDto.setMobile(secStaff.getMobileNo());
        staffDto.setName(secStaff.getStaffName());
        staffDto.setOrganizeCode(secStaff.getOrganizeCode());
        staffDto.setOrganizeId("10987");
        staffDto.setOrganizeName("34564");
        staffDto.setStaffCode(secStaff.getStaffCode());
        staffDto.setStaffId(secStaff.getStaffId() != null  ? String.valueOf(secStaff.getStaffId()):"");
        staffDto.setType(type);
        String strStaff = JSON.toJSONString(staffDto);
        Message<String> message = MessageBuilder.withPayload(strStaff)
                .setHeader(RocketMQHeaders.KEYS, 1)
                .build();
        // 设置发送地和消息信息并发送异步消息
        rocketMQTemplate.asyncSend(syncTag, message, new SendCallbackListener(1));
        log.info("pushAsyncMessage finish : ");
        ResponseMsg msg = new ResponseMsg();
        msg.setSuccessData(null);
        return 0;
    }

    @Override
    public SecStaff querySecStaff() {
        return secStaffMapper.querySecStaff();
    }

    @Override
    public int insertSecStaff(SecStaff secStaff) {
        int insResult = secStaffMapper.insert(secStaff);
       // this.data(secStaff,MethodEnum.insert.code,TypeEnum.staff.code);
        try {
            mqProductService.send(secStaff,MethodEnum.insert.code,TypeEnum.staff.code);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return insResult;
    }

    @Override
    public int updSecStaff(SecStaff secStaff) {
        int updResult = secStaffMapper.updateById(secStaff);
        //this.data(secStaff,MethodEnum.update.code,TypeEnum.staff.code);
        try {
            mqProductService.send(secStaff,MethodEnum.insert.code,TypeEnum.staff.code);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return updResult;
    }

    @Override
    public int delStaff(SecStaff secStaff) {
        int delResult = secStaffMapper.deleteById(secStaff.getStaffId());
        //this.data(secStaff,MethodEnum.delete.code,TypeEnum.staff.code);
        try {
            mqProductService.send(secStaff,MethodEnum.insert.code,TypeEnum.staff.code);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return delResult;
    }
}
