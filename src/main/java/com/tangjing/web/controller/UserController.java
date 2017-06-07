package com.tangjing.web.controller;

import com.tangjing.web.pojo.UserPojo;
import com.tangjing.web.service.impl.ISysUserImpl;
import com.tangjing.util.ResultJson;
import com.tangjing.util.page.PagePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Describe:
 * User:tangjing
 * Date:2017/3/4
 * Time:下午12:57
 */
@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    ISysUserImpl iSysUser;

    private String uri = "user/";

    @RequestMapping("init.htm")
    public String init() {
        return uri + "userList";
    }


    @RequestMapping("query.json")
    @ResponseBody
    public PagePojo queryUser(PagePojo pagePojo) {
        return iSysUser.queryUser(pagePojo);
    }


    @RequestMapping("add.htm")
    public String Add() {
        return uri + "userAdd";
    }


    @RequestMapping("add.json")
    @ResponseBody
    public ResultJson save(Model model, UserPojo userPojo) {
        ResultJson result = new ResultJson();
        try {
            iSysUser.add(userPojo);
            result.setSuccess(true);
            result.setMsg("新增数据成功");
        }
        catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg("新增数据失败:"+e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "delete.json", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResultJson delete(String[] delStrs, String[] date) throws Exception {
        ResultJson result = new ResultJson();

        try {
            iSysUser.delelet(delStrs);
            result.setSuccess(true);
            result.setMsg("删除数据成功");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsg("删除数据失败:"+e.toString());
        }

        return result;
    }

}
