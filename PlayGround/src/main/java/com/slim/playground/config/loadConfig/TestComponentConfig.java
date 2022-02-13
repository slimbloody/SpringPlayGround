package com.slim.playground.config.loadConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 配置里面注释掉了还能启动
@Data
@Component
@ConfigurationProperties(prefix = "config.test")
public class TestComponentConfig {
    private Integer beanValue1;
}
