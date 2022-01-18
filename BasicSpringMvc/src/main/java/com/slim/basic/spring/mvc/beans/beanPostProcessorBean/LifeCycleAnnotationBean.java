package com.slim.basic.spring.mvc.beans.beanPostProcessorBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class LifeCycleAnnotationBean {
    public LifeCycleAnnotationBean() {
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
