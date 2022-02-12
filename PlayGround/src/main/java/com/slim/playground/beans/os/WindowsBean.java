package com.slim.playground.beans.os;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WindowsBean {
    String name;

    public WindowsBean() {
        this.name = "WindowsBean";
        log.info("create WindowsBean");
    }
}
