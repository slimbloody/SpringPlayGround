package com.slim.basic.spring.mvc.beans.os;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinuxBean {
    String name;

    public LinuxBean() {
        this.name = "LinuxBean";
        log.info("create LinuxBean");
    }
}
