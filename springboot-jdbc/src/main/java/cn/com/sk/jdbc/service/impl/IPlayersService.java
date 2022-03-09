package cn.com.sk.jdbc.service.impl;

import cn.com.sk.jdbc.mapper.PlayersMapper;
import cn.com.sk.jdbc.service.PlayersService;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
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

    @Override
    public String getSql() {

        SQL sql =  new SQL(){
            @Override
            public SQL DELETE_FROM(String table) {
                return super.DELETE_FROM(table);
            }

            @Override
            public SQL WHERE(String... conditions) {
                return super.WHERE(conditions);
            }
        };
        sql.DELETE_FROM("Players");
        sql.WHERE("player_id =1");
        return sql.toString();
    }
}
