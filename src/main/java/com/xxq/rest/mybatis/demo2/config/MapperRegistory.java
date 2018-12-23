package com.xxq.rest.mybatis.demo2.config;

import com.xxq.rest.mybatis.demo2.dto.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoqiang
 * @Title: MapperRegistory
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-22 19:42
 */
public class MapperRegistory {
    public static final Map<String, MapperData> methodSqlMapping = new HashMap<>();

    //使用 1. 在这里配置
    //2. Java Bean的属性名字要和数据库表的名字一致
    public MapperRegistory() {
        methodSqlMapping.put("com.xxq.rest.mybatis.demo2.mapper.TestMapper.selectByPrimaryKey",
                new MapperData("select * from bbt_interact_activity_ref where id=%d", Test.class));
    }

    public class MapperData<T> {
        private String sql;
        private Class<T> type;

        public MapperData(String sql, Class<T> type) {
            this.sql = sql;
            this.type = type;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getType() {
            return type;
        }

        public void setType(Class<T> type) {
            this.type = type;
        }
    }

    public MapperData get(String nameSpace) {

        return methodSqlMapping.get(nameSpace);
    }

}
