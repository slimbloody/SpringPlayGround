package com.slim.basic.spring.mvc.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExcludeClazz1 {

    public static void main(String[] args) {
        String s = "ExcludeClazz1";
        System.out.println(s.contains("ExcludeClazz"));
    }
}
