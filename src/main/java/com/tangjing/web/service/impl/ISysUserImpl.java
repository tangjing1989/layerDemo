package com.tangjing.web.service.impl;

import com.tangjing.web.pojo.UserPojo;
import com.tangjing.util.page.PagePojo;

import java.sql.SQLException;

/**
 * Created by tangjing on 2017/3/6.
 */
public interface ISysUserImpl {

    PagePojo queryUser(PagePojo pojo);

    void delelet(String[] ids) throws SQLException;

    void add(UserPojo userPojo) throws Exception;
}
