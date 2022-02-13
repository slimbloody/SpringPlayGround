package com.slim.playground.config.conditionBean;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Repeatable(WindowsSettings.class)
public @interface WindowsSetting {
    String settingName();
    String settingValue();
}
