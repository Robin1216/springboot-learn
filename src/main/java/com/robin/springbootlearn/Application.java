package com.robin.springbootlearn;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication  // 表明是 spring boot 应用
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.robin"})
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);



        // 关闭热部署;或在 .yml 文件中配置 spring.devtools.restart.enabled: false
        // System.setProperty("spring.devtools.restart.enabled","false");

        SpringApplication app = new SpringApplication(Application.class);

        // 关闭 banner；或在 .yml 文件中配置 spring.main.banner-mode = off
        app.setBannerMode(Banner.Mode.OFF);

        app.run(args);
    }

}
