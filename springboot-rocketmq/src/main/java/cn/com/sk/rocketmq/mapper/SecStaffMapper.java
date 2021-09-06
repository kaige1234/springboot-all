package cn.com.sk.rocketmq.mapper;

import cn.com.sk.rocketmq.entity.SecStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
public interface SecStaffMapper extends BaseMapper<SecStaff> {


    SecStaff querySecStaff();


}
