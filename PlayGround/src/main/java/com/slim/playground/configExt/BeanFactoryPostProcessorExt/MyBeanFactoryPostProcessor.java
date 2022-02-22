package com.slim.playground.configExt.BeanFactoryPostProcessorExt;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        log.info("beanDefinitionCount: {}", beanDefinitionCount);
        Arrays.stream(beanDefinitionNames).forEach(i -> log.info("beanDefinitionNames: {}", i));
    }
}
