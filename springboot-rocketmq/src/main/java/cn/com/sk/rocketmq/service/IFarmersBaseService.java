package cn.com.sk.rocketmq.service;

import cn.com.sk.rocketmq.entity.FarmersBase;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 农户(家庭农场)基础信息 服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
public interface IFarmersBaseService extends IService<FarmersBase> {

    public String queryFarmerBase();
}
