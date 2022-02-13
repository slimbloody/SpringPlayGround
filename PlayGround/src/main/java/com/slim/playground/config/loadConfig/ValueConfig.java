package com.slim.playground.config.loadConfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 注释掉配置直接报错
@Data
@Component
public class ValueConfig {
    @Value("${a.b.c}")
    private Integer numberVal;
}
