package com.tangjing.web.controller;

import com.tangjing.util.SpringContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Describe:
 * User:tangjing
 * Date:2017/3/15
 * Time:下午1:57
 */

@Controller
@RequestMapping("example/")
public class Example {



    private  final static  String url="example/";



    @RequestMapping("toForm.htm")
    public String  toForm()
    {
        return url+"form";
    }


    /**
     * layui图标
     * @return
     */
    @RequestMapping("toIcon.htm")
    public String toIcon1()
    {
        return url+"icon";
    }





}
