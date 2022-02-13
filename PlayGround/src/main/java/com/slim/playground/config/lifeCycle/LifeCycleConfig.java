package com.slim.playground.config.lifeCycle;

import com.slim.playground.config.lifeCycle.LifeCycleAnnotationBean;
import com.slim.playground.config.lifeCycle.LifeCycleBeanPropertyBean;
import com.slim.playground.config.lifeCycle.LifeCycleInterfaceBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
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
}
