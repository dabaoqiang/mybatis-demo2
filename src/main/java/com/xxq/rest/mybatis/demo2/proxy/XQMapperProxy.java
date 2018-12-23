package com.xxq.rest.mybatis.demo2.proxy;

import com.xxq.rest.mybatis.demo2.config.MapperRegistory;
import com.xxq.rest.mybatis.demo2.session.XQSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xiaoqiang
 * @Title: MapperProxy
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-23 10:28
 */
public class XQMapperProxy<T> implements InvocationHandler {
    /**
     * 执行者
     */
    private XQSqlSession xqSqlSession;
    /**
     * 要代理的接口
     */
    private Class<T> mapperInterface;

    /**
     * 构造函数
     *
     * @param xqSqlSession
     * @param mapperInterface
     */
    public XQMapperProxy(XQSqlSession xqSqlSession, Class<T> mapperInterface) {
        this.xqSqlSession = xqSqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 获取Configuration读取的配置文件
         */
        MapperRegistory.MapperData mapperData = xqSqlSession.getXqConfiguration().mapperRegistory.get(
                method.getDeclaringClass().getName() + "." + method.getName()
        );
        if (null != mapperData) {
            System.out.println(String.format("SQL [ %s ], parameter [%s] ", mapperData.getSql(), args[0]));
            return xqSqlSession.selectOne(mapperData, String.valueOf(args[0]));
        }
        return method.invoke(proxy, args);
    }
}
