package com.slim.basic.spring.mvc.beans;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bean3 {
    String name;

    public Bean3() {
        this.name = "Bean3";
        log.info("create bean3");
    }
}
