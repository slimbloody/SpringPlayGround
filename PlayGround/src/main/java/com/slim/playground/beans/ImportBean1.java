package com.slim.playground.beans;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImportBean1 {
    String name;

    public ImportBean1() {
        this.name = "ImportBean";
        log.info("create ImportBean1");
    }
}
