package com.slim.playground.config.autowiredBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class ConstructorBean {
    private OrigBean origBean;

    /*
    默认在加在ioc容器中的组件, 容器启动会调用无参构造器创建对象, 再进行初始化赋值等操作
    标注在构造器上面的参数, 也会从容器中获取
    也可以标注在参数上

    public ConstructorBean(@Autowired OrigBean origBean) {
        this.origBean = origBean;
    }

    如果只有一个有参构造器, 那么有参构造器的@Autowired可以省略
     */
    @Autowired
    public ConstructorBean(OrigBean origBean) {
        this.origBean = origBean;
    }

    @Override
    public String toString() {
        return "getOrigBean pos: " + origBean;
    }
}
