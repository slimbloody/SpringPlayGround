package com.slim.playground.config.loadConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueConfig {
    @Value("${a.b.c}")
    private Integer numberVal;
}
