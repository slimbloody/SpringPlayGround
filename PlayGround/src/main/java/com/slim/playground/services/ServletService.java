package com.slim.playground.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServletService {
    public String test() {
        return "test";
    }
}
