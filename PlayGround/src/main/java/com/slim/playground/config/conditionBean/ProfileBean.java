package com.slim.playground.config.conditionBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
public class ProfileBean {
    private String env;
    private String name;
}
