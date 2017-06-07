package com.tangjing.util;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describe:
 * User:tangjing
 * Date:17/1/10
 * Time:下午4:25
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute(GlobalConstants.USER_SESSION_KEY);
        if (user == null) {
            System.out.println("尚未登录，调到登录页面");
            response.sendRedirect(request.getContextPath() + "/welcome.htm");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
        System.out.println("postHandle");
//
//        if(response.getStatus()==500){
//            model.setViewName("/common/page-505");
//        }else

        if (response.getStatus() == 404) {
            model.setViewName("/common/page-404");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
