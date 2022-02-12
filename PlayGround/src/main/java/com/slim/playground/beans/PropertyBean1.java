package com.slim.playground.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class PropertyBean1 {
    // 1. 基本数值
    // 2. SpEl #{}
    // 3. ${}: 环境变量的值
    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;
}
