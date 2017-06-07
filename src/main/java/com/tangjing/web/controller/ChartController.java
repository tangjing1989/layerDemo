package com.tangjing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Describe:
 * User:tangjing
 * Date:2017/3/16
 * Time:下午3:12
 */
@Controller
@RequestMapping("chart/")
public class ChartController {
    public  static final String uri ="chart/";

    @RequestMapping("sysinfo.htm")
    public String toSysinfo()
    {
        return uri+"sysinfo";
    }

    @RequestMapping("graph.htm")
    public String toGraph()
    {
        return uri+"graph";
    }

}
