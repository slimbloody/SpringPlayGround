package com.slim.playground.config.importBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ImportBean1 {
    String name;

    public ImportBean1() {
        this.name = "ImportBean";
        log.info("create ImportBean1");
    }
}
