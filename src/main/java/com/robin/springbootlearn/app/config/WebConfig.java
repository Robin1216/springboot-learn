package com.robin.springbootlearn.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author robin
 * @version v0.0.1
 * @since 2020-04-06 21:43
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 增加映射关系
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 使 /login/page 映射为 registerForm.html
        registry.addViewController("/login/page").setViewName("registerForm");
    }

    // 跨域请求配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")    // 允许跨域访问的路径
                .allowedOrigins("*")    // 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")    // 允许请求方法
                .maxAge(168000)    // 预检间隔时间
                .allowedHeaders("*")  // 允许头部设置
                .allowCredentials(true);    // 是否发送cookie
    }
}