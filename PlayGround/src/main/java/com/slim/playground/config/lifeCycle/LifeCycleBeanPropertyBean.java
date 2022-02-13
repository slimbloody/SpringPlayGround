package com.slim.playground.config.lifeCycle;

import lombok.extern.slf4j.Slf4j;

/*
1. 单实例: 容器启动的时候创建对象
2. 多实例: 在每次获取的时候创建对象
 */
@Slf4j
public class LifeCycleBeanPropertyBean {
    public LifeCycleBeanPropertyBean() {
        log.info("LifeCycleBeanPropertyBean create");
    }

    // 对象创建完成, 并赋值好, 调用初始化方法
    public void init() {
        log.info("LifeCycleBeanPropertyBean init");
    }

    // 销毁: 容器关闭的时候调用
    // 但是多实例的时候, 容器不进行销毁, 交给使用的人销毁
    // 要的时候容器帮你创建, 但是不会管理这个bean
    public void destroy() {
        log.info("LifeCycleBeanPropertyBean destroy");
    }

    // 比如 ProtoType 类型的bean, 会在被调用到的时候才去init, 但是容器关闭的时候不销毁, 多实例不管
}
