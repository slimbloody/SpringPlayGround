package com.slim.basic.spring.mvc.beans.beanPostProcessorBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class LifeCycleInterfaceBean implements InitializingBean, DisposableBean {
    public LifeCycleInterfaceBean() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("LifeCycleBean init");
    }

    @Override
    public void destroy() throws Exception {
        log.info("LifeCycleBean destroy");
    }
}
