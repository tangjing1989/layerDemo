package com.tangjing.web.controller;

import com.tangjing.util.CodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Describe:
 * User:tangjing
 * Date:2017/5/19
 * Time:下午4:12
 */

@Controller
@RequestMapping("template")
public class TemplateController {

    private String uri = "template/";

    @RequestMapping("/toManageList.htm")
    public String toManageList() {
        CodeUtil.autogeneration("test",new String[]{"TemplateFunction"});
        return uri+"templateList";
    }

}
