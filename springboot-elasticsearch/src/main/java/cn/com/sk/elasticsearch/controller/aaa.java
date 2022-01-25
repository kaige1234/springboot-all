package cn.com.sk.elasticsearch.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author sunkai
 * @title: aaa
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/2515:07
 */
public class aaa {
    public static void main(String[] args) {
        String address ="jdbc:es://http://127.0.0.1:9200/?timezone=UTC&page.size=250";

        /*Properties connectionProperties = connectionProperties();
        Connection connection =
                DriverManager.getConnection(address, connectionProperties);*/
    }
}
