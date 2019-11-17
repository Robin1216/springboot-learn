package com.robin.springbootlearn.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

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

        return "the first app";
    }
}
