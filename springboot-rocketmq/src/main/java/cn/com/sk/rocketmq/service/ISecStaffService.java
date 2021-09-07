package cn.com.sk.rocketmq.service;

import cn.com.sk.rocketmq.entity.SecStaff;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
public interface ISecStaffService extends IService<SecStaff> {

    SecStaff querySecStaff();

    int insertSecStaff(SecStaff secStaff);

    int updSecStaff(SecStaff secStaff);

    int delStaff(SecStaff secStaff);
}
