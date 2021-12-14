package cn.com.sk.jdbc.service.impl;

import cn.com.sk.jdbc.mapper.PlayersMapper;
import cn.com.sk.jdbc.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPlayersService implements PlayersService {

    @Autowired
    private PlayersMapper playersMapper;

    @Override
    public void get() {
        playersMapper.selectById(1);
    }
}
