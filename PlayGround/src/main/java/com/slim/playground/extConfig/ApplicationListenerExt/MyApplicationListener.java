package com.slim.playground.extConfig.ApplicationListenerExt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;


@Slf4j
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    // 容器中发布此事件后, 该方法会触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("event: {}", event);
    }
}
