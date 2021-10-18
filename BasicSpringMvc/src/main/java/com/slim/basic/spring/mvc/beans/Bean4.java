package com.slim.basic.spring.mvc.beans;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bean4 {
    String name;

    public Bean4() {
        this.name = "Bean4";
        log.info("create bean4");
    }
}
