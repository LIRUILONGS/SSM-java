package com.liruilong.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Classname SpringMVCConfig
 * @Description TODO
 * @Date 2021/6/1 16:23
 * @Created Li Ruilong
 */
@Configuration
@ComponentScan(basePackages = "com.liruilong",useDefaultFilters = false,includeFilters = {@ComponentScan.Filter(type =
        FilterType.ANNOTATION,classes = Controller.class),@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)})
public class SpringMVCConfig  extends WebMvcConfigurationSupport {

    /*
     * @return
     * @Description  静态资源处理器
     * @author Liruilong
     * @date  2021/6/2  13:22
     **/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/");
    }

    /*
     * @return
     * @Description   视图解析器
     * @author Liruilong
     * @date  2021/6/1  16:59
     **/
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/jsp/", ".jsp");
    }

    /*
     * @return
     * @Description
     * @author Liruilong
     * @date  2021/6/2  13:35
     **/
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello3").setViewName("hello");
    }


    /*
     * @return
     * @Description  消息转化器
     * @author Liruilong
     * @date  2021/6/2  13:35
     **/
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
       // MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(om);
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        converter.setFastJsonConfig(fastJsonConfig);
       // converters.add(converter);
        converters.add(converter);
    }

}
