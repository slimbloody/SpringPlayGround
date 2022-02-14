package com.slim.playground.config.autowiredBean;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class AutowiredBean {
    private String label = "1";
}
