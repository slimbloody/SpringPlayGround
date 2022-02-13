package com.slim.playground.config.importBean.factoryWay;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class FactoryBean1 {
    String name;

    public FactoryBean1() {
        this.name = "FactoryBean1";
        log.info("create FactoryBean1");
    }
}
