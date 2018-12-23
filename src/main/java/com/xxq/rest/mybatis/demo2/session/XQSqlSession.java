package com.xxq.rest.mybatis.demo2.session;

import com.xxq.rest.mybatis.demo2.config.XQConfiguration;
import com.xxq.rest.mybatis.demo2.config.MapperRegistory;
import com.xxq.rest.mybatis.demo2.executor.Executor;
import com.xxq.rest.mybatis.demo2.proxy.*;

import java.lang.reflect.Proxy;

/**
 * @author xiaoqiang
 * @Title: XQSqlSession
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-22 19:36
 */
public class XQSqlSession {

    private XQConfiguration xqConfiguration;
    private Executor executor;

    public XQSqlSession(XQConfiguration xqConfiguration, Executor executor) {
        this.xqConfiguration = xqConfiguration;
        this.executor = executor;
    }

    /**
     * 从sqlSession获取到绑定的配置文件，然后获取其加载的配置
     *
     * @return
     */
    public XQConfiguration getXqConfiguration() {
        return this.xqConfiguration;
    }

    // 获取mapper
    public <T> T getMapper(Class<T> clazz, XQSqlSession xqSqlSession) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
                new XQMapperProxy(this, clazz));
    }

    // 执行sql
    public <T> T selectOne(MapperRegistory.MapperData mapperData, Object parameters) {
        return executor.query(mapperData, parameters);
    }


}
