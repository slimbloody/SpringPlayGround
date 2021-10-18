package com.slim.basic.spring.mvc.typeFilter;

import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class ComponentCustomFilter1 implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();

        // todo: ExcludeClazz被打印出来了
        return classMetadata.getClassName().contains("ExcludeClazz");
    }
}
