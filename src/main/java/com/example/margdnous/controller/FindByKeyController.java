package com.example.margdnous.controller;


import com.example.margdnous.model.Annotation;
import com.example.margdnous.model.InputData;
import com.example.margdnous.repository.InputDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/findbykey")
@Slf4j
public class FindByKeyController {
    @Autowired
    InputDataRepository inputDataRepository;

    @RequestMapping(value = "/keysearch",method = RequestMethod.POST)
    public JSONObject keysearch(@RequestBody JSONObject inputjson){
        String senario = "";
        log.info("      keysearch 실행");
        JSONObject jsonObject = new JSONObject();
        log.info((String) inputjson.get("myDatakey"));
        InputData inputData = inputDataRepository.findByMyDataKey(Integer.parseInt((String)inputjson.get("myDataKey")));
        jsonObject.put("key",inputjson.get("myDataKey"));
        jsonObject.put("is_end",inputData.isEnd());
        jsonObject.put("label_name",inputData.getLabelNameList());
        jsonObject.put("senario",inputData.getSenario());
        jsonObject.put("url",inputData.getUrl());
        return jsonObject;
    }

}
