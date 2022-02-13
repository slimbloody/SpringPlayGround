package com.slim.playground.config.conditionBean;


import com.slim.playground.config.conditionBean.os.LinuxBean;
import com.slim.playground.config.conditionBean.os.WindowsBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OsTypeConfig {
    @Bean
    @ConditionalOnMissingBean(LinuxBean.class)
    public LinuxMissingBean linuxMissingBean() {
        return new LinuxMissingBean();
    }

    @Bean
    @Conditional({WindowsCondition.class})
    public WindowsBean windowsBean() {
        return new WindowsBean();
    }

    @Bean
    @Conditional({LinuxCondition.class})
    public LinuxBean linuxBean() {
        return new LinuxBean();
    }
}
