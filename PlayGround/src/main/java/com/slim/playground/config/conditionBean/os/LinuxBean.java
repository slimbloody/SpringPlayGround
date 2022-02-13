package com.slim.playground.config.conditionBean.os;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinuxBean {
    String name;

    public LinuxBean() {
        this.name = "LinuxBean";
        log.info("create LinuxBean");
    }
}
