package com.slim.playground.config.loadConfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/*
生成的beanName: config.test-com.slim.playground.config.loadConfig.TestBeanValueConfig
applicationContext.getBean("config.test-com.slim.playground.config.loadConfig.TestBeanValueConfig");
结果是null
 */

// todo: EnableConfigurationProperties是将BeanDefinition注册到BeanDefinitionRegistry上面, 但是具体生成了什么类还要细看
// 配置里面注销了还能启动
@Configuration
@EnableConfigurationProperties(value = {TestBeanValueConfig.class})
public class EnableTestBeanValueConfig {
}
