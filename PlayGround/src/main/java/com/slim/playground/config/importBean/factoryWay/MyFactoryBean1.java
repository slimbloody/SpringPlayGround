package com.slim.playground.config.importBean.factoryWay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

@Slf4j
public class MyFactoryBean1 implements FactoryBean<GenBean1> {
    // 返回一个对象, 将这个对象添加到容器中
    @Override
    public GenBean1 getObject() throws Exception {
        return new GenBean1();
    }

    @Override
    public Class<?> getObjectType() {
        return GenBean1.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
