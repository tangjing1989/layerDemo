package com.tangjing.util.interceptor;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.tangjing.util.GlobalConstants;
import com.tangjing.util.JsonUtil;
import com.tangjing.web.dao.UtilMapper;
import com.tangjing.web.pojo.UserPojo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;


@Aspect
@Component
public  class SystemLogAspect {

    @Resource
    UtilMapper utilMapper;

    //本地异常日志记录对象
    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);

    //Controller层切点
    @Pointcut("@annotation(com.tangjing.util.interceptor.ActionControllerLog)")
    public  void controllerAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut="controllerAspect()")
    public  void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint,null);
    }


    //    @AfterReturning(pointcut="controllerAspect()",argNames = "joinPoint,retVal",returning = "retVal")
    @AfterThrowing(value="controllerAspect()",throwing="e")
    public void doAfter(JoinPoint joinPoint,Exception e)
    {
        handleLog(joinPoint,e);
    }

        private void handleLog(JoinPoint joinPoint,Exception e) {
        try {
            //获得注解
            ActionControllerLog controllerLog = giveController(joinPoint);
            if(controllerLog == null)
            {
                return;
            }
            //获取当前的用户
            HttpServletRequest request   = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            UserPojo  userModel =JsonUtil.deserialize(request.getSession().getAttribute(GlobalConstants.USER_SESSION_KEY).toString(),UserPojo.class);


            //*========数据库日志=========*//
            UserlogModel userlogModel = new UserlogModel();
            //请求的IP
            String ip = request.getRemoteAddr();
            userlogModel.setUserIp(ip);
            userlogModel.setLogCrt(new Date());
            userlogModel.setUrl(request.getRequestURI());
            if(userModel != null)
            {
                userlogModel.setUserId(userModel.getUserId());
                userlogModel.setUserName(userModel.getUserName());
            }

            if(e != null)
                userlogModel.setErrorMessage(e.getMessage());

            //处理设置注解上的参数
            getControllerMethodDescription(controllerLog,userlogModel,request);
            //保存数据库
            utilMapper.saveLog(userlogModel);
        }  catch (Exception exp) {
            //记录本地异常日志
            logger.error("==前置通知异常==");
            logger.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @return 方法描述
     * @throws Exception
     */
    public  static void getControllerMethodDescription(ActionControllerLog controllerLog,UserlogModel userlogModel,HttpServletRequest request)  throws Exception {
        //设置action动作
        userlogModel.setAction(controllerLog.action());
        //设置标题
        userlogModel.setTitle(controllerLog.title());
        //设置channel
        userlogModel.setChannel(controllerLog.channel());
        //是否需要保存request，参数和值
        if(controllerLog.isSaveRequestData())
        {
            //获取参数的信息，传入到数据库中。
            setRequestValue(userlogModel,request);
        }
    }

    /**
     * 获取请求的参数，放到log中
     * @param userlogModel
     * @param request
     */
    @SuppressWarnings("rawtypes")
    private static void setRequestValue(UserlogModel userlogModel,HttpServletRequest request) {
        if(userlogModel == null)
            userlogModel = new UserlogModel();
        Map map = request.getParameterMap();
        String params = JSONObject.toJSONString(map);
        userlogModel.setRequestParam(params);
    }

    /**
     * 是否存在注解，如果存在就记录日志
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private static ActionControllerLog giveController(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if(method != null)
        {
            return method.getAnnotation(ActionControllerLog.class);
        }
        return null;
    }
}