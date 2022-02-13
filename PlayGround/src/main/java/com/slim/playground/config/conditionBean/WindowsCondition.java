package com.slim.playground.config.conditionBean;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class WindowsCondition implements Condition {
    /*
    ConditionContext: 判断条件能用的上下文
    AnnotatedTypeMetadata: 注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        // 获取当前环境信息
        Environment env = context.getEnvironment();

        // bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        MultiValueMap<String, Object> map = metadata.getAllAnnotationAttributes("com.slim.playground.config.conditionBean.WindowsSettings");

        String property = env.getProperty("os.name");

        if (property.contains("Windows")) {
            return true;
        }

        return false;
    }
}
