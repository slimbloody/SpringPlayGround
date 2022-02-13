package com.slim.playground.config.importBean;

import com.slim.playground.beans.RootBean1;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar1 implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // todo: ((DefaultListableBeanFactory) registry).beanDefinitionMap
        // 什么时候用全类名
        // 启动的时候bean1, bean2 没有全类名
        boolean hasImportBean1 = registry.containsBeanDefinition("com.slim.playground.config.importBean.ImportBean1");
        boolean hasImportBean2 = registry.containsBeanDefinition("com.slim.playground.beans.ImportBean2");

        if (hasImportBean1 && hasImportBean2) {
            // 指定Bean定义信息, (Bean type, Bean scope)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RootBean1.class);
            registry.registerBeanDefinition("rootBean1", beanDefinition);
        }
    }
}
