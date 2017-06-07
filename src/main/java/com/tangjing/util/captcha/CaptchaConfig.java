package com.tangjing.util.captcha;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/14
 * Time:下午4:31
 */

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import java.util.Properties;

/**
 * Describe:
 * User:tangjing
 * Date:17/2/2
 * Time:上午12:54
 */

@Configuration
public class CaptchaConfig {


        /*@Value("${kaptcha.border}")
    private String kborder;*/

    @Value("${kaptcha.session.key}")
    private String skey;

    @Value("${kaptcha.textproducer.font.color}")
    private String fcolor;

    @Value("${kaptcha.textproducer.font.size}")
    private String fsize;

    @Value("${kaptcha.obscurificator.impl}")
    private String obscurificator;

    @Value("${kaptcha.noise.impl}")
    private String noise;

    @Value("${kaptcha.image.width}")
    private String width;

    @Value("${kaptcha.image.height}")
    private String height;

    @Value("${kaptcha.textproducer.char.length}")
    private String clength;

    @Value("${kaptcha.textproducer.char.space}")
    private String cspace;

    @Value("${kaptcha.background.clear.from}")
    private String from;

    @Value("${kaptcha.background.clear.to}")
    private String to;

//    @Bean(name = "captchaProducer")
//    public ServletRegistrationBean servletRegistrationBean() throws ServletException {
//        ServletRegistrationBean servlet = new ServletRegistrationBean(new KaptchaServlet(), "/images/kaptcha.jpg");
//        servlet.addInitParameter("kaptcha.border", "no"/*kborder*/);//无边框
//        servlet.addInitParameter("kaptcha.session.key", skey);//session key
//        servlet.addInitParameter("kaptcha.textproducer.font.color", fcolor);
//        servlet.addInitParameter("kaptcha.textproducer.font.size", fsize);
//        servlet.addInitParameter("kaptcha.obscurificator.impl", obscurificator);
//        servlet.addInitParameter("kaptcha.noise.impl", noise);
//        servlet.addInitParameter("kaptcha.image.width", width);
//        servlet.addInitParameter("kaptcha.image.height", height);
//        servlet.addInitParameter("kaptcha.textproducer.char.length", clength);
//        servlet.addInitParameter("kaptcha.textproducer.char.space", cspace);
//        servlet.addInitParameter("kaptcha.background.clear.from", from); //和登录框背景颜色一致
//        servlet.addInitParameter("kaptcha.background.clear.to", to);
//        return servlet;
//    }

    @Bean(name="captchaProducer")
    public DefaultKaptcha getKaptchaBean(){
        DefaultKaptcha defaultKaptcha =new DefaultKaptcha();
        Properties     properties     =new Properties();
        properties.setProperty("kaptcha.border", "no"/*kborder*/);//无边框
        properties.setProperty("kaptcha.session.key", skey);//session key
        properties.setProperty("kaptcha.textproducer.font.color", fcolor);
        properties.setProperty("kaptcha.textproducer.font.size", fsize);
        properties.setProperty("kaptcha.obscurificator.impl", obscurificator);
        properties.setProperty("kaptcha.noise.impl", noise);
        properties.setProperty("kaptcha.image.width", width);
        properties.setProperty("kaptcha.image.height", height);
        properties.setProperty("kaptcha.textproducer.char.length", clength);
        properties.setProperty("kaptcha.textproducer.char.space", cspace);
        properties.setProperty("kaptcha.background.clear.from", from); //和登录框背景颜色一致
        properties.setProperty("kaptcha.background.clear.to", to);
        Config config =new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}