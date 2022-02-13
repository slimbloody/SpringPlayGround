package com.slim.playground.config.conditionBean;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class LinuxBean {
    String name;

    public LinuxBean() {
        this.name = "LinuxBean";
        log.info("create LinuxBean");
    }
}
