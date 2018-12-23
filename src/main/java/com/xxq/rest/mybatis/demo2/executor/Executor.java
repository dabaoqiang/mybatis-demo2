package com.xxq.rest.mybatis.demo2.executor;

import com.xxq.rest.mybatis.demo2.config.MapperRegistory;

/**
 * @author xiaoqiang
 * @Title: Executor
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-23 10:45
 */
public interface Executor {
    /**
     * 查询
     * mapperData 指定查询sql，以及返回类型
     * @param mapperData
     * @param parameters
     * @param <T>
     * @return
     */
    <T> T query(MapperRegistory.MapperData mapperData, Object parameters);

}
