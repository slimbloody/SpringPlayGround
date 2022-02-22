package com.slim.playground.configExt.BeanFactoryPostProcessorExt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 所有的bean定义信息将要加载,bean实例还未创建的时候执行, 听起来像在 BeanFactoryPostProcessor 之前
 因为
 在beanFactory 标准初始化之后调用, 所有bean定义 "已经" 保存加载到beanFactory


 org.springframework.context.support.PostProcessorRegistrationDelegate#invokeBeanDefinitionRegistryPostProcessors
 BeanDefinitionRegistryPostProcessor 先执行, 也是一样的优先级 先priorityOrder 再order 再无序的

 先postProcessBeanDefinitionRegistry
 再postProcessBeanFactory

 执行完了BeanDefinitionRegistryPostProcessor的两个方法

 再执行其他 BeanFactoryPostProcessor: invokeBeanFactoryPostProcessors

 */
@Slf4j
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
      BeanDefinitionRegistry 是 bean 定义的保存中心
      以后BeanFactory就是按照BeanDefinitionRegistry 里面保存的每一个bean定义信息创建bean实例的
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
        RootBeanDefinition bd1 = new RootBeanDefinition(BeanDefinitionBean1.class);
        AbstractBeanDefinition bd2 = BeanDefinitionBuilder
            .rootBeanDefinition(BeanDefinitionBean2.class)
            .getBeanDefinition();

        registry.registerBeanDefinition("bd1", bd1);
        registry.registerBeanDefinition("bd2", bd2);
    }

    // 这个是 BeanFactoryPostProcessor 的
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory");
    }
}
