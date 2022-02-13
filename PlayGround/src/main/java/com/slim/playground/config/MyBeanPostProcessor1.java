package com.slim.playground.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyBeanPostProcessor1 implements BeanPostProcessor {
    // Object bean: 刚刚创建好的实例
    // String beanName: 实例的名字
    // The returned bean instance may be a wrapper around the original

    // populateBean(beanName, mbd, instanceWrapper);
    // exposedObject = initializeBean(beanName, exposedObject, mbd);
    /*
    populateBean往bean里面注入属性之后, 走bean的初始化
     */

    // org.springframework.beans.factory.config.AutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization: {}", bean.getClass());
        return bean;
    }

    // org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#invokeInitMethods

    // org.springframework.beans.factory.config.AutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization: {}", bean.getClass());
        return bean;
    }
}
