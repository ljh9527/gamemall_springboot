package com.gamemall.gamemall.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Slf4j
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + staticPath + File.separator + "image/");
    }
}