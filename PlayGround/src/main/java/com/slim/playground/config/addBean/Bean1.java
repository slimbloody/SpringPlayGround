package com.slim.playground.config.addBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bean1 {
    String name;

    public Bean1() {
        this.name = "Bean1";
        log.info("create bean1");
    }
}
