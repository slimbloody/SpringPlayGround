package com.slim.playground.controller.feature;

import org.springframework.context.annotation.Bean;

public class CommonBean {
    @Bean
    public CommonBean commonBean() {
        return new CommonBean();
    }
}
