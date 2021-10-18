package com.slim.basic.spring.mvc.beans;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImportSelectorBean2 {
    String name;

    public ImportSelectorBean2() {
        this.name = "ImportSelectorBean2";
        log.info("create ImportSelectorBean2");
    }
}
