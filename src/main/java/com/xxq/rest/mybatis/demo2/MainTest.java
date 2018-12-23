package com.xxq.rest.mybatis.demo2;

import com.xxq.rest.mybatis.demo2.config.XQConfiguration;
import com.xxq.rest.mybatis.demo2.dto.Test;
import com.xxq.rest.mybatis.demo2.executor.SimpleExecutor;
import com.xxq.rest.mybatis.demo2.mapper.TestMapper;
import com.xxq.rest.mybatis.demo2.session.XQSqlSession;

/**
 * @author xiaoqiang
 * @Title: MainTest
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-23 11:53
 *
 * 思考总结：
 * 2.0版本，就是对
 *
 */
public class MainTest {
    public static void main(String[] args) {
        XQConfiguration xqConfiguration = new XQConfiguration();
        XQSqlSession xqSqlSession = new XQSqlSession(xqConfiguration, new SimpleExecutor(xqConfiguration));
        TestMapper mapper = xqSqlSession.getMapper(TestMapper.class, xqSqlSession);
        Test test = mapper.selectByPrimaryKey(1);
        System.out.println(test.toString());
    }
}
