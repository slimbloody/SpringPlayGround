package com.slim.playground.controller.springAsync;

import java.util.concurrent.Callable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {
    @PostMapping("/callable")
    public Callable<String> callableString() {
        log.info("main start: " + Thread.currentThread().getId() + " curNanoTime: " + System.nanoTime());
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("main start: " + Thread.currentThread().getId() + " curNanoTime: " + System.nanoTime());
                Thread.sleep(3000);
                log.info("main end: " + Thread.currentThread().getId());
                log.info("curNanoTime: " + System.nanoTime());
                return "callableString";
            }
        };
        log.info("main end: " + Thread.currentThread().getId() + " curNanoTime: " + System.nanoTime());
        return callable;
    }
}
