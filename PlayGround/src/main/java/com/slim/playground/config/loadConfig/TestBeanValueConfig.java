package com.slim.playground.config.loadConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

// 配置里面注释掉了还能启动
@Data
@ConfigurationProperties(prefix = "config.test")
public class TestBeanValueConfig {
    private Integer beanValue1;
}
