package com.slim.basic.spring.mvc.beans.autowiredBean;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConstructorParamBean {
    private OrigBean origBean;

    public ConstructorParamBean(@Autowired OrigBean origBean) {
        this.origBean = origBean;
    }

    @Override
    public String toString() {
        return "getOrigBean pos: " + origBean;
    }
}
