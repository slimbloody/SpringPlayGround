package com.slim.playground.config.autowiredBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Data
public class ConstructorParamBean {
    private OrigBean origBean;

    public ConstructorParamBean(@Autowired OrigBean origBean) {
        this.origBean = origBean;
    }

    @Override
    public String toString() {
        return "ConstructorParamBean: " + origBean.hashCode();
    }
}
