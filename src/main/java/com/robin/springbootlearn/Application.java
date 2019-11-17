package com.robin.springbootlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication  // 表明是 spring boot 应用
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
