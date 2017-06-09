package com.tangjing.web.controller;

import com.tangjing.util.*;
import com.tangjing.util.interceptor.ActionControllerLog;
import com.tangjing.util.serverInfo.GetServerInfo;
import com.tangjing.util.serverInfo.ServerInfoPojo;
import com.tangjing.web.dao.DataTemplateMapper;
import com.tangjing.web.dao.UtilMapper;
import com.tangjing.web.pojo.UserPojo;
import com.tangjing.web.service.impl.ISysImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Describe:
 * User:tangjing
 * Date:2017/3/3
 * Time:下午4:26
 */
@Controller

public class SysController {


    private static final String kapthaCode = com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;
    @Autowired
    ISysImpl           iSysImpl;
    @Autowired
    UtilMapper         utilMapper;
    @Autowired
    DataTemplateMapper mapper;

    @RequestMapping({"/", "welcome.htm"})
    public String init(Model model, HttpServletRequest request, RedirectAttributes attr) {
        model.addAttribute("enableVerif", SpringContextService.IS_KAPTCHA);
        return "login";
    }

    @RequestMapping("/main.htm")
    public String main(Model model, HttpServletRequest request) {
        model.addAttribute("menu1s", iSysImpl.queryLev1Menu());
        UserPojo user=JsonUtil.deserialize(request.getSession().getAttribute(GlobalConstants.USER_SESSION_KEY).toString(),UserPojo.class);
        model.addAttribute("user",user);
        return "index";
    }


    @ActionControllerLog(title = "访问主页", action = "吃饭", isSaveRequestData = true, channel = "web")
    @RequestMapping("/index.htm")
    public String index(Model model, HttpServletRequest request) {
        ServerInfoPojo serverInfoPojo = GetServerInfo.getServerInfo();
        model.addAttribute("serverInfoPojo", serverInfoPojo);
        return "sysinfo/sysinfo";
    }

    @RequestMapping("/querySysInfo.json")
    @ResponseBody
    public ServerInfoPojo querySysInfo(Model model, HttpServletRequest request) {
        return GetServerInfo.getServerInfo();
    }


    @RequestMapping("/login.htm")
    public String doLogin(HttpServletRequest request, String userCode, String password, String verifCode, Model model, String code) {
        try {
            //判断用户有无session信息
            if (null != request.getSession().getAttribute(GlobalConstants.USER_SESSION_KEY)) {
                return "redirect:/main.htm";
            }
            //判断是否启用验证码功能
            if (SpringContextService.IS_KAPTCHA.equals("true")) {
                model.addAttribute("enableVerif", kapthaCode);
                //判断验证码是否为空
                if (StringUtils.isEmpty(verifCode)) {
                    throw new CustomException("VERIFCODE_NULL");
                }
                //判断验证码是否正确
                String kaptchaExpected = (String) request.getSession().getAttribute(kapthaCode);
                if (!verifCode.equals(kaptchaExpected)) {
                    throw new CustomException("VERIFCODE_ERROR");
                }
            }

            //使用用户名密码查询是否存在该用户
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("userCode", userCode);
            map.put("password", password);
            List<Map<String, Object>> result = utilMapper.commonQueryPojo("user", map);
            List<UserPojo>            users  = BeanUtil.toBeanList(UserPojo.class, result);
            //如果用户不存在则进一步判断1：用户名是否存在；2.密码是否正确
            if (users.size() == 0) {
                //判断是否存在该用户
                map.clear();
                map.put("userCode", userCode);
                int sum1 = utilMapper.commonQuerySum("user", map);
                if (sum1 == 0) {
                    throw new CustomException("USER_NOT_EXIST");
                }
                //判断用户名密码是否正确
                map.put("password", password);
                int sum2 = utilMapper.commonQuerySum("user", map);
                if (sum2 == 0) {
                    throw new CustomException("lOGIN_ERROR");
                }
            }
            request.getSession().setAttribute(GlobalConstants.USER_SESSION_KEY, JsonUtil.serialize(users.get(0)));
            return "redirect:/main.htm";
        } catch (CustomException e) {
            Message.getMessage(model, e.getMessage());
            return "forward:/welcome.htm";
        } catch (Exception e) {
            Message.getMessage(model, "SERVER_ERROR");
            return "forward:/welcome.htm";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {

        request.getSession().removeAttribute(GlobalConstants.USER_SESSION_KEY);
        return "redirect:/";
    }


}
