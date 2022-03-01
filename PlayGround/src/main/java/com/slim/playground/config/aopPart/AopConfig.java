package com.slim.playground.config.aopPart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@EnableAspectJAutoProxy
@Import(value = {CalculateAspect.class})
public class AopConfig {
    @Bean
    public CalculateComponent calculateComponent() {
        return new CalculateComponent();
    }
}


