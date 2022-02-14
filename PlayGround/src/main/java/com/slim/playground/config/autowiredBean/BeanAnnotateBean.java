package com.slim.playground.config.autowiredBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
@Data
public class BeanAnnotateBean {
    @Bean
    public OrigBean origBean() {
        return new OrigBean();
    }
}
