package com.slim.playground.config.scopeBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/*
容器启动的时候不会初始化ProtoTypeBean, 直到用到这个bean的时候才开始初始化, 才会有log打出来
todo: 如果在其他地方@AutoWired这个prototype bean也会触发初始化
 */
@Slf4j
@Data
public class ProtoTypeBean {
    String name;

    public ProtoTypeBean() {
        this.name = "ProtoTypeBean";
        log.info("create ProtoTypeBean");
    }
}
