package com.slim.playground.configExt.BeanFactoryPostProcessorExt;

import com.slim.playground.configExt.NormalBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 BeanPostProcessor: bean后置处理器, bean创建对象初始化前后进行拦截工作的
 BeanFactoryPostProcessor: beanFactory后置处理器
    在beanFactory 标准初始化之后调用, 所有bean定义已经保存加载到beanFactory
    但是bean的实例还未创建


 Application contexts can auto-detect BeanFactoryPostProcessor beans in their bean definitions and apply them before any other beans get created.


 All bean definitions will have been loaded, but no beans will have been instantiate yet.
 beanDefinition 已经加载了, 还没有bean被初始化


 执行时机
 1. org.springframework.context.support.AbstractApplicationContext#invokeBeanFactoryPostProcessors(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
 */

@Import(value = {
    MyBeanFactoryPostProcessor.class,
    MyBeanDefinitionRegistryPostProcessor.class
})
@Slf4j
public class BeanFactoryPostProcessorConfig {
    @Bean
    public NormalBean normalBean() {
        log.info("create normalBean");
        return new NormalBean();
    }
}
