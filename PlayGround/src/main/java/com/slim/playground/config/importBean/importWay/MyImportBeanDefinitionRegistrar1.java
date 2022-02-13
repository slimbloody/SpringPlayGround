package com.slim.playground.config.importBean.importWay;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar1 implements ImportBeanDefinitionRegistrar {
    /*
    BeanDefinitionRegistry: BeanDefinition注册类
    把所需要添加到容器中的bean 调用
    registry.registerBeanDefinition 手动 注册到容器里面
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // ((DefaultListableBeanFactory) registry).beanDefinitionMap 能看所有的bean
        // 这里判断的是全类名
        boolean hasImportBean1 = registry.containsBeanDefinition("com.slim.playground.config.importBean.importWay.ImportBean1");
        boolean hasImportBean2 = registry.containsBeanDefinition("com.slim.playground.beans.ImportBean2");

        if (hasImportBean1 && hasImportBean2) {
            // todo: RootBeanDefinition 是什么
            // 指定Bean定义信息, (Bean type, Bean scope)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RootBean1.class);
            registry.registerBeanDefinition("rootBean1", beanDefinition);
        }
    }
}
