package com.tangjing.util.config;


import org.springframework.beans.factory.InitializingBean;

import java.util.ResourceBundle;

/**
 * Describe:
 * User:tangjing
 * Date:17/1/25
 * Time:上午10:24
 */

public class ConfigServiceImpl implements IConfigService, InitializingBean {


    ResourceBundle resource;


    String resourceName;


    @Override
    public String getValue(String key) {
        return resource.getString(key);
    }


    public String getMiddleware()
    {

        return resource.getString("Middleware");
    }

    public String getIskaptcha()
    {

        return resource.getString("Iskaptcha");
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }



    @Override
    public void afterPropertiesSet() {
        this.resource = ResourceBundle.getBundle(resourceName);
    }
}