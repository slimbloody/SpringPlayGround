package com.slim.playground.test.basicJava.threadLocal;

public class BasicTypeContext {
    private static final ThreadLocal<Boolean> threadLocal = new ThreadLocal<>();

    public static Boolean get() {
        return threadLocal.get();
    }

    public static void set(boolean val) {
        threadLocal.set(val);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
