package com.tangjing.web.service.impl;

import com.tangjing.web.dao.SysUserMapper;
import com.tangjing.web.dao.UtilMapper;
import com.tangjing.web.pojo.UserPojo;
import com.tangjing.util.CustomException;
import com.tangjing.util.page.PagePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Describe:
 * User:tangjing
 * Date:2017/3/6
 * Time:上午10:40
 */
@Service
public class SysUserImpl implements ISysUserImpl {

    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    UtilMapper    utilMapper;

    public PagePojo queryUser(PagePojo pojo) {
        pojo.init(sysUserMapper.queryUserListCount(pojo));
        pojo.setDatas(sysUserMapper.queryUserListPage(pojo));
        return pojo;
    }

    public void delelet(String[] ids) throws SQLException {
        for (String id : ids)
            sysUserMapper.delete(id);
    }

    public void add(UserPojo userPojo) throws SQLException,CustomException {
        Map<String,String> params=new HashMap<>();
        String tableName="user";
        params.put("userCode",userPojo.getUserCode());
        params.put("userName",userPojo.getUserName());
       int num= utilMapper.commonQuerySum(tableName,params);
       if(num>0)
           throw new CustomException("存在相同的userCode和userName组合");
        sysUserMapper.addUser(userPojo);
    }
}
