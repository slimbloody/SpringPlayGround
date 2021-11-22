package com.slim.basic.spring.mvc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "config.test")
public class TestBeanValueConfig {
    private Integer beanValue1 = 0;
}
