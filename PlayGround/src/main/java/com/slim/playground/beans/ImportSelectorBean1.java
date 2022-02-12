package com.slim.playground.beans;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImportSelectorBean1 {
    String name;

    public ImportSelectorBean1() {
        this.name = "ImportSelectorBean1";
        log.info("create ImportSelectorBean1");
    }
}
