package com.tangjing.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tangjing.util.JsonUtil;
import com.tangjing.web.pojo.UserTest;
import com.tangjing.web.service.IUserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Yanghu
 * @since 2017-05-25
 */
@Controller
@RequestMapping("/web/userTest")
public class UserTestController {
    @Autowired
    IUserTestService iUserTestService;
@RequestMapping("/query")
    public String  to() {
        return  "template/templateList";
    }

    @RequestMapping("query.json")
    @ResponseBody
    public String  query(Page page1) {
        Page<UserTest> res  = iUserTestService.selectPage(page1, null);
        return JsonUtil.serialize(res).toString();
    }
}
