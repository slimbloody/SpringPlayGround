package com.slim.playground.config.importBean.importWay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
public class MyImportSelector1 implements ImportSelector {
    // AnnotationMetadata importingClassMetadata
    // 标记了@Import注解的类的所有注解信息
    // 不只能拿到自己这个注解, 还能拿到其他注解

    /*
    如果这个方法返回null, 接下来走到
    org.springframework.context.annotation.ConfigurationClassParser#asSourceClasses
	List<SourceClass> annotatedClasses = new ArrayList<>(classNames.length);
	classNames这里是null, 会包空指针异常, 所以这里只能返回空数组
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        log.info("annotation: {}", importingClassMetadata.getAnnotationTypes());
        log.info("importingClassMetadata: {}", importingClassMetadata.getAllAnnotationAttributes("org.springframework.context.annotation.Configuration"));
        return new String[]{
            "com.slim.playground.config.importBean.importWay.ImportSelectorBean1",
            "com.slim.playground.config.importBean.importWay.ImportSelectorBean2"
        };
    }
}
