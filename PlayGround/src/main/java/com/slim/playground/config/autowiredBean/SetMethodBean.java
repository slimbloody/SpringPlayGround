package com.slim.playground.config.autowiredBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Data
public class SetMethodBean {
    private OrigBean origBean;

    // 标注在方法上, Spring容器创建当前对象, 就会调用方法, 完成赋值
    // 方法使用的参数, 自定义类型的值从ioc容器中获取
    @Autowired
    public void setMethodBean(OrigBean origBean) {
        this.origBean = origBean;
    }

    @Override
    public String toString() {
        return "SetMethodBean: " + origBean.hashCode();
    }
}
