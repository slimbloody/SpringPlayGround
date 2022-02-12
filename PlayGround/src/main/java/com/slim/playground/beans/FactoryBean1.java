package com.slim.playground.beans;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryBean1 {
    String name;

    public FactoryBean1() {
        this.name = "FactoryBean1";
        log.info("create FactoryBean1");
    }
}
