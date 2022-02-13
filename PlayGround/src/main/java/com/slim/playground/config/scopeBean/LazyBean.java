package com.slim.playground.config.scopeBean;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class LazyBean {
    String name;

    public LazyBean() {
        this.name = "LazyBean";
        log.info("create LazyBean");
    }
}
