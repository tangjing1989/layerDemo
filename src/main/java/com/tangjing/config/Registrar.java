package com.tangjing.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Describe:实现自己实例化bean并注册为Spring管理
 * User:tangjing
 * Date:17/2/2
 * Time:上午12:19
 */


@Configuration
@Import(Registrar.class)
public class Registrar implements ImportBeanDefinitionRegistrar {

    private static final String BEAN_NAME = "PageBaseUtil";


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//
//        if (!registry.containsBeanDefinition(BEAN_NAME)) {
//            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//            beanDefinition.setBeanClass(PageBaseUtil.class);
//            beanDefinition.setSynthetic(true);
//            registry.registerBeanDefinition(BEAN_NAME, beanDefinition);
//        }
    }

}
