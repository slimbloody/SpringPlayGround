package com.slim.basic.spring.mvc.beans.autowiredBean;

import lombok.Data;

@Data
public class BeanAnnotateBean {
    private OrigBean origBean;

    @Override
    public String toString() {
        return "getOrigBean pos: " + origBean;
    }
}
