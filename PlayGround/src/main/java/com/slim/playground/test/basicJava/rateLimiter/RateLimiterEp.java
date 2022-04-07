package com.slim.playground.test.basicJava.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterEp {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2);
    }
}
