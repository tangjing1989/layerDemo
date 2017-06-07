package com.tangjing.web.controller;

import com.tangjing.util.CustomException;
import com.tangjing.util.SysConstants;
import com.tangjing.util.page.PagePojo;
import com.tangjing.web.pojo.TablePojo;
import com.tangjing.web.service.ISysManageDataBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Describe:系统管理
 * User:tangjing
 * Date:2017/4/20
 * Time:下午4:20
 */
@Controller
@RequestMapping("SysManage/DataBase")
public class SysManageDataBaseController {
    @Autowired
    ISysManageDataBaseImpl iSysManageDataBase;

    String uri = "sysManage/dataBaseManage/";

    @RequestMapping("dataBaseInit.htm")
    public String dataBaseInit() {
        return uri + "databaseList";
    }

    @RequestMapping("query.json")
    @ResponseBody
    public PagePojo query(PagePojo pagePojo) {
        return iSysManageDataBase.query(pagePojo);
    }

    @RequestMapping("add.htm")
    public String initAdd(Model modle)
    {

        modle.addAttribute("DataTypes",SysConstants.getListByName("DataType"));
        return uri+"dataBaseAdd";
    }

    @RequestMapping(value="add.json", method = RequestMethod.POST)
    @ResponseBody
    public String save(Model model,TablePojo tablePojo)
    {
        try {
            iSysManageDataBase.save(tablePojo);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        return null;
    }
}
