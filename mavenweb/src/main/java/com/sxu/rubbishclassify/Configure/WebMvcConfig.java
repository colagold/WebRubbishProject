package com.sxu.rubbishclassify.Configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Value("web.upload-path")
    private String path;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //将所有path访问都映射到/image/** 路径下
        registry.addResourceHandler("/image/**").addResourceLocations("file:/root/web/image/");
        registry.addResourceHandler("/video/**").addResourceLocations("file:E:\\Desktop\\");
    }
}


