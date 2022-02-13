package com.slim.playground.config.conditionBean;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class WindowsBean {
    String name;

    public WindowsBean() {
        this.name = "WindowsBean";
        log.info("create WindowsBean");
    }
}
