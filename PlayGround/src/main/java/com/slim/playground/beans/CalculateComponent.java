package com.slim.playground.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CalculateComponent {
    public Integer addCalculate(int x, int y) {
        log.info("addCalculate");
        return x + y;
    }

    public Integer addCalculateThrowException(int x, int y) {
        log.info("addCalculate");
        throw new ArithmeticException();
    }
}
