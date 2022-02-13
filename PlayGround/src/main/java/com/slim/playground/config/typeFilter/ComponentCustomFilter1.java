package com.slim.playground.config.typeFilter;

import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class ComponentCustomFilter1 implements TypeFilter {
    // MetadataReader metadataReader: 读取到的当前正在扫描的类的信息
    // MetadataReaderFactory metadataReaderFactory: 可以获取到其他任何类信息的
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();

        System.out.println(classMetadata.getClassName());
        // todo: ExcludeClazz被打印出来了
        return classMetadata.getClassName().contains("ExcludeClazz");
    }
}
