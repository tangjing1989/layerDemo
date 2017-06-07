package com.tangjing.web.dao;

import com.tangjing.web.pojo.MenuPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Describe:
 * User:tangjing
 * Date:17/1/16
 * Time:上午10:49
 */
public interface SysMapper {

    List<MenuPojo> queryMenuByLev(@Param("lev") String lev);

}
