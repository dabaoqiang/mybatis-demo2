package com.xxq.rest.mybatis.demo2.result;

import com.xxq.rest.mybatis.demo2.config.MapperRegistory;
import com.xxq.rest.mybatis.demo2.config.XQConfiguration;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author xiaoqiang
 * @Title: ResultSetHandler
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-23 11:05
 */
public class ResultSetHandler {
    private XQConfiguration xqConfiguration;

    public ResultSetHandler(XQConfiguration xqConfiguration) {
        this.xqConfiguration = xqConfiguration;
    }

    /**
     * 将结果集进行封装
     *
     * @param pstmt
     * @param mapperData
     * @param <E>
     * @return
     * @throws SQLException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public <E> E hanlder(PreparedStatement pstmt, MapperRegistory.MapperData mapperData) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // TODO defaultObjectFactory.create() new出所传对象的实例
        Object resultObj = new DefaultObjectFactory().create(mapperData.getType());
        ResultSet rs = pstmt.getResultSet();
        if (rs.next()) {
            int i = 0;
            for (Field field : resultObj.getClass().getDeclaredFields()) {
                if(field.getName().equals("serialVersionUID")){
                    continue;
                }
                setValue(resultObj, field, rs, i);
            }
        }
        return (E) resultObj;
    }

    /**
     * 通过反射给set属性赋值
     */
    private void setValue(Object object, Field field, ResultSet resultSet, int i) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Method setMethod = object.getClass().getMethod("set" + upperCapital(field.getName()),
                field.getType());
        setMethod.invoke(object, getResult(field, resultSet));
    }

    /**
     * 填充数据 rs.getLong(1);
     *
     * @return
     */
    private Object getResult(Field field, ResultSet rs) throws SQLException {
        //TODO type handles
        Class<?> type = field.getType();
        if(Integer.class == type){
            return rs.getInt(field.getName());
        }
        if (Long.class == type) {
            return rs.getLong(field.getName());
        }
        if(String.class == type){
            return rs.getString(field.getName());
        }
        if (Date.class == type) {
            return rs.getDate(field.getName());
        }
        return rs.getString(field.getName());
    }

    /**
     * 首字母大写
     *
     * @param name
     */
    public static String upperCapital(String name) {
        String first = name.substring(0, 1);
        String tail = name.substring(1);
        return first.toUpperCase() + tail;
    }

}
