package com.slim.playground.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
ThreadLocal应该算一个包装类, 因为每次都是找到currentThread, 然后再去取里面的ThreadLocalMap的,
使用static修饰的变量是类变量, 使用static修饰后是为了减少对象的创建，减少空间占用(每次都是找到currentThread再做操作)
每个线程都有一个ThreadLocalMap, 包装类用key(threadLocal的hashCode值)去取threadLocalMap里面的Entry,
 */

@RestController
@RequestMapping("/ThreadLocal")
@Slf4j
public class ThreadLocalController {
    @PostMapping("/test")
    public void test() {
        try {
            ThreadLocalMsg msg = ThreadLocalMsg.builder().num(1).build();
            ThreadLocalContext.set(msg);

            ThreadLocalMsg threadLocalMsg1 = ThreadLocalContext.get();
            log.info("{}", threadLocalMsg1);

            msg.setVal(2);
            ThreadLocalMsg threadLocalMsg2 = ThreadLocalContext.get();
            log.info("{}", threadLocalMsg2);
        } finally {
            ThreadLocalContext.remove();
        }
    }
}
