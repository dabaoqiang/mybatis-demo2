package com.xxq.rest.mybatis.demo2.mapper;

import com.xxq.rest.mybatis.demo2.dto.Test;

/**
 * @author xiaoqiang
 * @Title: TestMapper
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-23 10:14
 */
public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);

}
