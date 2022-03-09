package cn.com.sk.jdbc.controller;

import cn.com.sk.jdbc.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/test")
public class Testontroller {

    @Autowired
    private PlayersService playersService;

    @RequestMapping("/get")
    public void get(){
        playersService.get();
    }

    @RequestMapping("/getSql")
    public String getSql(){
        return playersService.getSql();
    }
}
