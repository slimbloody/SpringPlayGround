package com.slim.playground;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringPlayGroundApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringPlayGroundApplication.class, args);
        } catch (Throwable throwable) {
            System.out.println(throwable);
            log.error("failed\n", throwable);
        }
    }
}
