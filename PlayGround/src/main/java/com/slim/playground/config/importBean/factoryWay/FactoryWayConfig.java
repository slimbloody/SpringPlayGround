package com.slim.playground.config.importBean.factoryWay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryWayConfig {
    @Bean
    public MyFactoryBean1 myFactoryBean1() {
        return new MyFactoryBean1();
    }
}
