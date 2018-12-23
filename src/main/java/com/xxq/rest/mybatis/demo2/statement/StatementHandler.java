package com.xxq.rest.mybatis.demo2.statement;

import com.xxq.rest.mybatis.demo2.config.MapperRegistory;
import com.xxq.rest.mybatis.demo2.config.XQConfiguration;
import com.xxq.rest.mybatis.demo2.result.ResultSetHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xiaoqiang
 * @Title: StatementHandler
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-23 10:58
 */
public class StatementHandler {
    private XQConfiguration xqConfiguration;

    private ResultSetHandler resultSetHandler;

    public StatementHandler(XQConfiguration xqConfiguration) {
        this.xqConfiguration = xqConfiguration;
        resultSetHandler = new ResultSetHandler(xqConfiguration);
    }

    public <E> E query(MapperRegistory.MapperData mapperData, Object parameters)  {
        try {
            // TODO 获取连接
            Connection connection = getConnection();
            // TODO parameterHandler
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(mapperData.getSql(), Integer.parseInt(String.valueOf(parameters))));
            preparedStatement.execute();
            // TODO ResultSetHandler
            return (E) resultSetHandler.hanlder(preparedStatement, mapperData);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return  null;
    }


    /**
     * 获取数据库连接
     *
     * @return
     */
    private Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/bbt_promote?useUnicode=true&characterEncoding=UTF8";
        String user = "jusravimgdju";
        String pass = "Bbt_54321";
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
