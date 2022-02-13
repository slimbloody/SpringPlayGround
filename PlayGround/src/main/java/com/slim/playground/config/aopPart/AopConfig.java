package com.slim.playground.config.aopPart;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AopConfig {
}

/**
 * AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar: 自定义注入bean
 * 1. AUTO_PROXY_CREATOR_BEAN_NAME = "org.springframework.aop.config.internalAutoProxyCreator"
 * AnnotationAwareAspectJAutoProxyCreator 是通过函数里面的cls变量传进来的
 * internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 * 给spring注册一个 AnnotationAwareAspectJAutoProxyCreator(注解装配模式的AspectJ切面自动代理创建器)
 *
 */
