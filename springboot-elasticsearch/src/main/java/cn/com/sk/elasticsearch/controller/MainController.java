package cn.com.sk.elasticsearch.controller;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.xpack.sql.jdbc.EsDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunkai
 * @title: MainController
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/2511:13
 */
@Slf4j
public class MainController {



    public static void main(String[] args) throws Exception {

        String url = "jdbc:es://http://127.0.0.1:9200";
        Connection connection = getConnection(url);
        //showDatabases(connection);
//        showTables(connection);
        //showColumns(connection);
        testExcuteSQL(connection);
    }

    /**
     * 测试执行SQL.
     *
     * @param connection
     * @throws Exception
     */
    private static void testExcuteSQL(Connection connection) throws Exception{
        PreparedStatement preparedStatement = connection.prepareStatement("select * from megacorp");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Object> resultList = handleResultSet(resultSet);
        log.info("结果：{}", resultList);
    }

    private static List<Object> handleResultSet(ResultSet resultSet) throws SQLException {
        List<Object> result = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new LinkedHashMap<>();
            int total = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= total; i++) {
                map.put(resultSet.getMetaData().getColumnName(i), null == resultSet.getObject(i) ? null : resultSet.getObject(i).toString());
            }
            result.add(map);
        }
        return result;
    }

    /**
     * 查看所有数据库.
     *
     * @param connection
     * @throws Exception
     */
    public static void showDatabases(Connection connection) throws Exception{
        ResultSet schemas = connection.getMetaData().getCatalogs();
        while (schemas.next()){
            System.out.println(schemas.getObject("TABLE_CAT"));
        }
    }

    /**
     * 查看数据库所有表.
     *
     * @param connection
     * @throws Exception
     */
    public static void showTables(Connection connection) throws Exception{
        ResultSet tables = connection.getMetaData().getTables(null, null, null, null);
        while (tables.next()) {
//            System.out.println(tables.getString("TABLE_NAME"));
            String TABLE_CAT = tables.getString("TABLE_CAT");
            String TABLE_SCHEM = tables.getString("TABLE_SCHEM");
            String TABLE_NAME = tables.getString("TABLE_NAME");
            String TABLE_TYPE = tables.getString("TABLE_TYPE");
            String REMARKS = tables.getString("REMARKS");
            log.info("表类别：{}、表模式：{}、表名称：{}、表类型：{}、表描述：{}", TABLE_CAT, TABLE_SCHEM, TABLE_NAME, TABLE_TYPE, REMARKS);
        }
    }

    /**
     * 查看表所有字段.
     *
     * @param connection
     * @throws Exception
     */
    public static void showColumns(Connection connection) throws Exception{
        ResultSet tables = connection.getMetaData().getColumns(null, null, "megacorp", null);
        while (tables.next()) {
            String TABLE_CAT = tables.getString("TABLE_CAT");
            String TABLE_SCHEM = tables.getString("TABLE_SCHEM");
            String TABLE_NAME = tables.getString("TABLE_NAME");
            String columnName = tables.getString("COLUMN_NAME");
            String typeName = tables.getString("TYPE_NAME");
            String columnSize = tables.getString("COLUMN_SIZE");
            String REMARKS = tables.getString("REMARKS");
            log.info("表类别：{}、表模式：{}、表名称：{}、字段名称：{}、字段类型：{}、字段大小：{}、字段描述：{}",
                    TABLE_CAT, TABLE_SCHEM, TABLE_NAME, columnName, typeName, columnSize, REMARKS);
        }
    }

    /**
     * 获取数据源.
     *
     * @param url
     * @return
     */
    private static DataSource getESDataSource(String url){
        EsDataSource esDataSource = new EsDataSource();
        esDataSource.setUrl(url);
        return esDataSource;
    }

    /**
     * 获取连接connection.
     *
     * @param url
     * @return
     */
    private static Connection getConnection(String url){
        DataSource esDataSource = getESDataSource(url);
        Connection connection = null;
        try {
            connection = esDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
