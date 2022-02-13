package com.slim.playground.config.conditionBean;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionBeanConfig {
    // LinuxBean没创建成功则创建
    @Bean
    @ConditionalOnMissingBean(LinuxBean.class)
    public LinuxMissingBean linuxMissingBean() {
        return new LinuxMissingBean();
    }

    // os.name有windows则创建
    @Bean
    @Conditional({WindowsCondition.class})
    @WindowsSetting(settingName = "graphicsCard", settingValue = "1080Ti")
    @WindowsSetting(settingName = "hardDrive", settingValue = "HDD")
    public WindowsBean windowsBean() {
        return new WindowsBean();
    }

    // os.name有linux则创建
    @Bean
    @Conditional({LinuxCondition.class})
    public LinuxBean linuxBean() {
        return new LinuxBean();
    }
}
