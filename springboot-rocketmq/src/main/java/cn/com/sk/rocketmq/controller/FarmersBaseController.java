package cn.com.sk.rocketmq.controller;


import cn.com.sk.rocketmq.entity.SecStaff;
import cn.com.sk.rocketmq.service.IFarmersBaseService;
import cn.com.sk.rocketmq.service.ISecStaffService;
import cn.com.sk.rocketmq.service.impl.FarmersBaseServiceImpl;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 农户(家庭农场)基础信息 前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-09-06
 */
@RestController
@RequestMapping("/farmers")
public class FarmersBaseController {

    @Autowired
    private IFarmersBaseService farmersBaseService;

    @Autowired
    private ISecStaffService secStaffService;

    @RequestMapping("/queryFarmers")
    public String queryFarmers(){
        return farmersBaseService.queryFarmerBase();
    }

    @RequestMapping("/querySecStaff")
    public String querySecStaff(){
        return JSON.toJSONString(secStaffService.querySecStaff());
    }

    @RequestMapping("/insertSecStaff")
    public int insertSecStaff(@RequestBody SecStaff secStaff){
        return secStaffService.insertSecStaff(secStaff);
    }

    @RequestMapping("/updStaff")
    public int updStaff(@RequestBody SecStaff secStaff){
        return secStaffService.updSecStaff(secStaff);
    }
}
