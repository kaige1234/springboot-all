package cn.com.sk.rocketmq.mapper;

import cn.com.sk.rocketmq.entity.FarmersBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 农户(家庭农场)基础信息 Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
public interface FarmersBaseMapper extends BaseMapper<FarmersBase> {

    String queryFarmer();

}
