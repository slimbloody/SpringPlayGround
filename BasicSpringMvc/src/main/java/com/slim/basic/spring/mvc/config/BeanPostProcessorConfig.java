package com.slim.basic.spring.mvc.config;

import com.slim.basic.spring.mvc.beans.beanPostProcessorBean.LifeCycleAnnotationBean;
import com.slim.basic.spring.mvc.beans.beanPostProcessorBean.LifeCycleBeanPropertyBean;
import com.slim.basic.spring.mvc.beans.beanPostProcessorBean.LifeCycleInterfaceBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeanPostProcessorConfig {
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
}
