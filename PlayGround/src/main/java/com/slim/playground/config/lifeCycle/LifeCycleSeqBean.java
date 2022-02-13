package com.slim.playground.config.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class LifeCycleSeqBean implements InitializingBean, DisposableBean {
/*
create
-------------------------
postConstruct
afterPropertiesSet
annotation-init
-------------------------
preDestroy
destroy
annotation-destroy
-------------------------
 */

    public LifeCycleSeqBean() {
        log.info("LifeCycleSeqBean create");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("LifeCycleSeqBean postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("LifeCycleSeqBean preDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("LifeCycleSeqBean afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("LifeCycleSeqBean destroy");
    }

    public void annotationInit() {
        log.info("LifeCycleSeqBean annotation-init");
    }

    public void annotationDestroy() {
        log.info("LifeCycleSeqBean annotation-destroy");
    }
}
