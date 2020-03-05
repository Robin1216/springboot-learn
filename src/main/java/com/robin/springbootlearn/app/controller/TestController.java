package com.robin.springbootlearn.app.controller;

import com.robin.springbootlearn.common.annotations.SysLog;
import com.robin.springbootlearn.common.enums.RequestOptTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // @Controller 和 @ResponseBody 的组合
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @SysLog(optName = "测试", optType = RequestOptTypeEnum.READ, moduleName = "测试", detail = "查询测试")
    @PostMapping("/first")
    String index(){

        log.trace("log.trace ....");
        log.debug("log.debug ....");
        log.info("log.info ....");
        log.warn("log.warn ....");
        log.error("log.error ....");

        logger.trace("logger.trace ...");
        logger.debug("logger.debug ...");
        logger.info("logger.info ...");
        logger.warn("logger.warn ...");
        logger.error("logger.error ...");

        test();

        return "the first app";
    }

    @SysLog(optName = "测试", optType = RequestOptTypeEnum.READ, moduleName = "测试", detail = "查询测试")
    private void test(){

    }
}
