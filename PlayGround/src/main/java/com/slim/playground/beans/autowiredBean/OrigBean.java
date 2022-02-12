package com.slim.playground.beans.autowiredBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrigBean {
    private String beanName = "orig_bean";
}
