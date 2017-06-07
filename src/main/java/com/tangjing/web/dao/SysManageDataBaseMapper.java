package com.tangjing.web.dao;

import com.tangjing.util.page.PagePojo;
import com.tangjing.web.pojo.TablePojo;
import com.tangjing.web.pojo.UserPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * Created by tangjing on 2017/4/20.
 */
public interface SysManageDataBaseMapper {

    List<TablePojo> queryListPage(@Param("pojo") PagePojo pojo, @Param("tableSchema") String tableSchema);

    int queryListCount(@Param("pojo") PagePojo pojo,@Param("tableSchema")String tableSchema);

    int createTable(@Param("tableName") String tableName,@Param("sqls") String[] sqls,@Param("keySql")String keySql,@Param("comment") String comment);

}
