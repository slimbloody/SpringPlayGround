package com.slim.playInAction.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusSelfConfiguration {
    @Bean
    @ConditionalOnProperty(name={"mybatis-plus.self-configuration.enable-cal-execution-time"}, havingValue = "true")
    public Object object() {
        return null;
    }
}
