package com.liruilong.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Classname SpringConfig
 * @Description TODO
 * @Date 2021/6/1 11:54
 * @Created Li Ruilong
 *
 * 这个配置类的作用相当于 applicationContext.xml
 */
@ComponentScan(basePackages = "com.liruilong",useDefaultFilters = true
        ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})
@Configuration
public class SpringConfig {

}
