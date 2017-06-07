package com.tangjing.web.dao;

import com.tangjing.web.pojo.UserPojo;
import com.tangjing.util.page.PagePojo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

/**
 * Describe:
 * User:tangjing
 * Date:2017/3/6
 * Time:上午10:41
 */
@Mapper
public interface SysUserMapper {

    List<UserPojo> queryUserListPage(@Param("pojo") PagePojo pojo);

    int queryUserListCount(@Param("pojo") PagePojo pojo);

    @Insert("insert into USER (userName,userCode,password,crtDate,uptDate) values(#{user.userName},#{user.userCode},#{user.password},NOW(),NOW())")
    int addUser(@Param("user") UserPojo user) throws SQLException;

    @Delete("delete from user where  userid=#{id}")
    void delete(@Param("id")String id)throws SQLException;
}
