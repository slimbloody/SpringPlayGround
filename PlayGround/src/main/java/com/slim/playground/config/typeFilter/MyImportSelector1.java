package com.slim.playground.config.typeFilter;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector1 implements ImportSelector {
    // AnnotationMetadata importingClassMetadata
    // 标记了@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
            "com.slim.playground.config.importBean.ImportSelectorBean1",
            "com.slim.playground.config.importBean.ImportSelectorBean2"
        };
    }
}