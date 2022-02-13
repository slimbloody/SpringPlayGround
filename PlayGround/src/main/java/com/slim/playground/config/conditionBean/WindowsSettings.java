package com.slim.playground.config.conditionBean;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.aspectj.weaver.ClassAnnotationValue;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface WindowsSettings {
    WindowsSetting[] value();
}
