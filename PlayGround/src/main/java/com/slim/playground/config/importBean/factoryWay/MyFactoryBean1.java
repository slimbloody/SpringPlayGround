package com.slim.playground.config.importBean.factoryWay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

@Slf4j
public class MyFactoryBean1 implements FactoryBean<FactoryBean1> {
    @Override
    public FactoryBean1 getObject() throws Exception {
        return new FactoryBean1();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBean1.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
