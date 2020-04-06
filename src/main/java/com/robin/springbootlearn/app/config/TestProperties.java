package com.robin.springbootlearn.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * springboot 类型安全配置测试
 *
 * @author robin
 * @version v0.0.1
 * @create 2020-03-06 08:01
 */
@Data
//@Component  // 配置类注解，让 Component Scan 扫描到
@ConfigurationProperties(prefix = "test")  // 指明前缀
@PropertySource(value = {"classpath:config/test.properties"}, encoding = "UTF-8")  // 指明配置位置及编码，config 前不加 '/',不然找不到相应的配置文件
@EnableConfigurationProperties
@ConstructorBinding // SpringBoot2.2版本发行后支持了构造函数的方式进行绑定。 此时需要用 @EnableConfigurationProperties 或 @ConfigurationPropertiesScan 将此属性绑定
public class TestProperties {

    /*
        Spring boot 提供了基于类型安全的配置方式，通过 @ConfigurationProperties 将 properties 的一个属性
        和一个 Bean 及其属性关联，从而实现将外部配置文件进行类型安全的配置。
        Bean 类中的 getXXX 的 xxx 必须和字段名 properties的属性名严格一致，否则出异常，即使松弛绑定，也要这样。
        这里用 lombok 插件 @Data 的注解代替传统的 getXXX、setXXX 方法

        @PropertySource 加载外部配置文件，其属性：
        1.value：指明加载配置文件的路径。 
        2.ignoreResourceNotFound：指定的配置文件不存在是否报错，默认是false。当设置为 true 时，若该文件不存在，
        程序不会报错。实际项目开发中，最好设置 ignoreResourceNotFound 为 false。 
        3.encoding：指定读取属性文件所使用的编码，我们通常使用的是UTF-8。

        在获取外部配置文件属性时，可以使用 @Value 进行获取，但是如果注入的值较多时，代码就会显得冗余；
        @ConfigurationProperties(prefix = "test")  的前缀设置可以比较好的减少冗余，使用 @EnableConfigurationProperties
        开启 @ConfigurationProperties 注解。

        注意：使用 @PropertySource 时要添加如下依赖，不然在 idea 中会出现 Spring Boot Configuration Annotation Processor
        not found in classpath 的提示
         <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-configuration-processor</artifactId>
             <optional>true</optional>
         </dependency>
     */


    private Long id;

    private String name;

    private final Pic pic;

    @Data
    private static class Pic{

        private String url;

        private String name;
    }
}