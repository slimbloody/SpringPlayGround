package com.slim.playground.config.aopPart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@EnableAspectJAutoProxy
@Import(value = {CalculateAspect.class})
@Configuration
public class AopConfig {
    @Bean
    public CalculateComponent calculateComponent() {
        return new CalculateComponent();
    }
}


