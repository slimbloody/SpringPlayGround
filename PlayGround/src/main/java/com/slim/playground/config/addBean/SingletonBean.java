package com.slim.playground.config.addBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SingletonBean {
    String name;

    public SingletonBean() {
        this.name = "SingletonBean";
        log.info("create SingletonBean");
    }
}
