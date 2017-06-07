package com.tangjing.web.dao;

import com.tangjing.util.interceptor.UserlogModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Describe:工具类的mapper
 * User:tangjing
 * Date:2017/3/22
 * Time:下午3:22
 */
@Mapper
public interface UtilMapper {

    @Insert("INSERT into userLog" +
                "(userLogID,userId,userName,userIp,url,channel,action,title,logCrt,requestParam,errorMessage) " +
            "VALUES " +
               "(#{userlogModel.userLogID}," +
                "#{userlogModel.userId}," +
                "#{userlogModel.userName}," +
                "#{userlogModel.userIp}," +
                "#{userlogModel.url}," +
                "#{userlogModel.channel}," +
                "#{userlogModel.action}," +
                "#{userlogModel.title}," +
                "#{userlogModel.logCrt}," +
                "#{userlogModel.requestParam}," +
                "#{userlogModel.errorMessage}" +
            ")")
    void saveLog(@Param("userlogModel") UserlogModel userlogModel)throws SQLException;

    /**
     * 通用查询
     * @param tableName 表名
     * @param params 字段
     * @return
     * @throws SQLException
     */
    int commonQuerySum(@Param("tableName")String  tableName,@Param("params") Map<String,String> params )throws SQLException;

    List<Map<String, Object>> commonQueryPojo(@Param("tableName")String  tableName, @Param("params") Map<String,String> params )throws SQLException;

}
