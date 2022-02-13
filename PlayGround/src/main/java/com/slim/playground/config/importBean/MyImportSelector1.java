package com.slim.playground.config.importBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
public class MyImportSelector1 implements ImportSelector {
    // AnnotationMetadata importingClassMetadata
    // 标记了@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        log.info("annotation: {}", importingClassMetadata.getAnnotationTypes());
        log.info("importingClassMetadata: {}", importingClassMetadata.getAllAnnotationAttributes("org.springframework.context.annotation.Configuration"));
        return new String[]{
            "com.slim.playground.config.importBean.ImportSelectorBean1",
            "com.slim.playground.config.importBean.ImportSelectorBean2"
        };
    }
}
