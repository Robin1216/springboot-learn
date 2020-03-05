package com.robin.springbootlearn.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author silkNets
 * @program springboot-learn
 * @description Jackson 使用方式测试
 * @createDate 2020-02-27 09:32
 */
@RestController
public class JacksonController {

    /*
    Jackson
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
    采用数
     */
    @GetMapping("/readTree.json")
    public @ResponseBody
    String readTree() throws JsonProcessingException {
        String jsonStr = "{\"name\":\"Ji\",\"id\":1}";

        JsonNode node = objectMapper.readTree(jsonStr);

        String name = node.get("name").asText();

        int id = node.get("id").asInt();

        return "name:" + name + ", id:" + id;

    }
}