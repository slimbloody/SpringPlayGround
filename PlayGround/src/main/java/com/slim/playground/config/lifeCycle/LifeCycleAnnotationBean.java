package com.slim.playground.config.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LifeCycleAnnotationBean {
    public LifeCycleAnnotationBean() {
        log.info("LifeCycleAnnotationBean create");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("LifeCycleAnnotationBean init");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("LifeCycleAnnotationBean destroy");
    }
}
