package com.slim.playground.config.conditionBean;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinuxMissingBean {
    String name;

    public LinuxMissingBean() {
        this.name = "LinuxMissingBean";
        log.info("create LinuxMissingBean");
    }
}
