package com.tangjing.web.dao;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/18
 * Time:下午10:18
 */
import org.apache.ibatis.annotations.Param;

import java.util.Map;


public interface DataTemplateMapper {



    int createNewTable(@Param("tableName")String tbaleName,@Param("map") Map map);
    int dropTable(@Param("tableName") String tableName);
    int existTable(String tableName);
}