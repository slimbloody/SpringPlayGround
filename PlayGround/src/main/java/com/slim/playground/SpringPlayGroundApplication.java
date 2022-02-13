package com.slim.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPlayGroundApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringPlayGroundApplication.class, args);
        } catch (Throwable throwable) {
            System.out.println("failed");
        }
    }
}
