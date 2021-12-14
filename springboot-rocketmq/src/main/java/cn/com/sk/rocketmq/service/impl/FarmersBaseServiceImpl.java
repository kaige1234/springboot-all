package cn.com.sk.rocketmq.service.impl;

import cn.com.sk.rocketmq.entity.FarmersBase;
import cn.com.sk.rocketmq.mapper.FarmersBaseMapper;
import cn.com.sk.rocketmq.service.IFarmersBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 农户(家庭农场)基础信息 服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
@Service
public class FarmersBaseServiceImpl extends ServiceImpl<FarmersBaseMapper, FarmersBase> implements IFarmersBaseService {

    @Autowired
    private FarmersBaseMapper farmersBaseMapper;

    @Override
    public String queryFarmerBase() {

       return farmersBaseMapper.queryFarmer();

    }
}
