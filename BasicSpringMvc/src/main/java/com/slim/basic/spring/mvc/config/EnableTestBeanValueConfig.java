package com.slim.basic.spring.mvc.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {TestBeanValueConfig.class})
public class EnableTestBeanValueConfig {
}
