package com.slim.playground.config.addBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bean2 {
    String name;

    public Bean2() {
        this.name = "Bean2";
        log.info("create bean2");
    }
}
