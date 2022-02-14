package com.slim.playground.config.autowiredBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class OrigBean {
    private String beanName = "orig_bean";

    @Override
    public String toString() {
        return "OrigBean: " + this.hashCode();
    }
}
