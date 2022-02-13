package com.slim.playground.config.importBean.importWay;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RootBean1 {
    String name;

    public RootBean1() {
        this.name = "RootBean1";
        log.info("create RootBean1");
    }
}
