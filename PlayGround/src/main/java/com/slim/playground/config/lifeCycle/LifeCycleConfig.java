package com.slim.playground.config.lifeCycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(value = {MyBeanPostProcessor1.class})
public class LifeCycleConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public LifeCycleBeanPropertyBean lifeCycleBean() {
        return new LifeCycleBeanPropertyBean();
    }

    @Bean
    public LifeCycleInterfaceBean lifeCycleInterfaceBean() {
        return new LifeCycleInterfaceBean();
    }

    @Bean
    public LifeCycleAnnotationBean lifeCycleAnnotationBean() {
        return new LifeCycleAnnotationBean();
    }

    @Bean(initMethod = "annotationInit", destroyMethod = "annotationDestroy")
    public LifeCycleSeqBean lifeCycleSeqBean() {
        return new LifeCycleSeqBean();
    }
/*
LifeCycleSeqBean create
LifeCycleBean init
LifeCycleBean def-init
 */
}
