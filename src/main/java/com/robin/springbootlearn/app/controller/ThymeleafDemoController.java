package com.robin.springbootlearn.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author silkNets
 * @program springboot-learn
 * @description thymeleaf 示例
 * @createDate 2020-02-27 13:40
 */
@Slf4j
@Controller
public class ThymeleafDemoController {

    // 此处注意类上要使用 @Controller；不能使用 @RestController，不然返回的将是反序列话的内容，而不是视图
    @RequestMapping(value = "/")
    public String index(Model model) {
        log.info("Thymeleaf index 。。。");

        // 根据 Thymeleaf 默认模版，Thymeleaf 默认前缀为 classpath:/templates/，默认后缀为 html, 将返回 classpath:/templates/index.html
        return "index";
    }

    @PostMapping("login")
    public ModelAndView login(ModelAndView modelAndView,
                              @RequestParam("loginName") String loginName,
                              @RequestParam("password") String password) {

        log.info("用户 {} 的登录密码为 {}", loginName, password);

        // 重定向到 main 请求
        modelAndView.setViewName("redirect:/main");

        return modelAndView;
    }

    @RequestMapping(value = "/main")
    public String main() {
        log.info("main method ...");

        // 根据 Thymeleaf 默认模版，将返回 resources/templates/main.html
        return "main";
    }

}