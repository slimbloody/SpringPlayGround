package com.slim.playground.config.importBean.importWay;

import org.springframework.context.annotation.Import;


/*
@Import: 给容器导入组件
1. @Import
2. ImportSelector: 导入组件的全类名数组
3. ImportBeanDefinitionRegistrar: 通过BeanDefinition 手动注册到容器中
 */

// @Configuration
// 注释掉 @Configuration, 则不用加入自动装配了
@Import(
    value = {
        // 导入组件, id默认是组件的全类名
        // com.slim.playground.config.importBean.importWay.ImportBean1
        ImportBean1.class,
        // 导入组件的全类名数组
        MyImportSelector1.class,
        MyImportBeanDefinitionRegistrar1.class
    }
)
public class ImportAnnotationConfig {
}
