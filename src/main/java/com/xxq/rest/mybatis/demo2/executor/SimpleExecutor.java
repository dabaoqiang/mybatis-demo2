package com.xxq.rest.mybatis.demo2.executor;

import com.xxq.rest.mybatis.demo2.config.XQConfiguration;
import com.xxq.rest.mybatis.demo2.config.MapperRegistory;
import com.xxq.rest.mybatis.demo2.statement.StatementHandler;

/**
 * @author xiaoqiang
 * @Title: SimpleExecutor
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-23 10:47
 */
public class SimpleExecutor implements Executor {

    private XQConfiguration xqConfiguration;

    public SimpleExecutor(XQConfiguration xqConfiguration) {
        this.xqConfiguration = xqConfiguration;
    }

    public XQConfiguration getXqConfiguration() {
        return xqConfiguration;
    }

    public void setXqConfiguration(XQConfiguration xqConfiguration) {
        this.xqConfiguration = xqConfiguration;
    }

    /**
     * 查询
     * mapperData 指定查询sql，以及返回类型
     *
     * @param mapperData
     * @param parameters
     * @return
     */
    public <E> E query(MapperRegistory.MapperData mapperData, Object parameters) {
        // TODO 初始化statement
        StatementHandler statementHandler = new StatementHandler(xqConfiguration);
        return (E) statementHandler.query(mapperData, parameters);
    }
}
