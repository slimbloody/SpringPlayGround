package com.slim.playground.test.basicJava.lombok;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@ToString
@EqualsAndHashCode
@SuperBuilder
public class BaseClass {
    private int a;
}
