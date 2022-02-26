package com.slim.playground.controller.servlet;

import com.slim.playground.services.ServletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServletService service;

    @PostMapping("/test")
    public String test() {
        return service.test();
    }
}
