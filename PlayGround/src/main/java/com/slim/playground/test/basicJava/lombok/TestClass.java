package com.slim.playground.test.basicJava.lombok;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestClass {
    public static void main(String[] args) {
        DerivedClass build = DerivedClass.builder().a(1).b(2).build();
        log.info("DerivedClass: {}, {}, {}", build, build.getA(), build.getB());
    }
}
