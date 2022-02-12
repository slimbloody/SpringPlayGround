package com.slim.playground.config;

import com.slim.playground.beans.ImportBean1;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/*
@Import: 给容器导入组件
1. @Import
2. ImportSelector: 导入组件的全类名数组
3. ImportBeanDefinitionRegistrar: 通过BeanDefinition 手动注册到容器中
 */

@Configuration
@Import(
    value = {
        ImportBean1.class,
        MyImportSelector1.class,
        MyImportBeanDefinitionRegistrar1.class
    }
)
public class ImportAnnotationConfig {
}
