package com.slim.playground.beans.autowiredBean;

import lombok.Data;

@Data
public class BeanAnnotateBean {
    private OrigBean origBean;

    @Override
    public String toString() {
        return "getOrigBean pos: " + origBean;
    }
}
