package com.tangjing.util.config;

/**
 * Describe:获取配置文件
 * User:tangjing
 * Date:17/1/25
 * Time:上午10:24
 */

public interface IConfigService {


    String getValue(String name);

    String getMiddleware();

    String getIskaptcha();




}
