package com.slim.playground.config.loadConfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {TestBeanValueConfig.class})
public class EnableTestBeanValueConfig {
}
