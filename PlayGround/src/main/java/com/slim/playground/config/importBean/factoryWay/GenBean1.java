package com.slim.playground.config.importBean.factoryWay;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class GenBean1 {
    String name;

    public GenBean1() {
        this.name = "GenBean1";
        log.info("create GenBean1");
    }
}
