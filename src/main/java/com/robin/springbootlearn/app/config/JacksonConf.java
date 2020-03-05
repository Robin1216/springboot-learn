package com.robin.springbootlearn.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author silkNets
 * @program springboot-learn
 * @description Jackson 配置
 * @createDate 2020-02-27 09:25
 */
@Configuration
public class JacksonConf {

    // 自定义序列化的形式，代替默认的
    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return objectMapper;
    }

}