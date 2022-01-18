package com.slim.basic.spring.mvc.config.loadConfig;

import com.slim.basic.spring.mvc.config.loadConfig.TestBeanValueConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {TestBeanValueConfig.class})
public class EnableTestBeanValueConfig {
}
