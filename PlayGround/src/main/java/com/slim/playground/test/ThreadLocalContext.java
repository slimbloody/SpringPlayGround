package com.slim.playground.test;

public class ThreadLocalContext {
    private static final ThreadLocal<ThreadLocalMsg> msg = new ThreadLocal<>();

    public static ThreadLocalMsg get() {
        return msg.get();
    }

    public static void set(ThreadLocalMsg threadLocalMsg) {
        msg.set(threadLocalMsg);
    }

    public static void remove() {
        msg.remove();
    }
}
