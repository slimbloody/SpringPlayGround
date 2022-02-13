package com.slim.playground.config.conditionBean;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinuxMissingBean {
    String name;

    public LinuxMissingBean() {
        this.name = "Bean4";
        log.info("create bean4");
    }
}
