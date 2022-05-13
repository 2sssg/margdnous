package com.example.margdnous.controller;

import com.example.margdnous.DTO.AnnotationDTO;
import com.example.margdnous.model.Annotation;
import com.example.margdnous.repository.AnnotationReposiroty;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/temp")
@Slf4j
public class Controller {
    @Autowired
    AnnotationReposiroty annotationReposiroty;

    @RequestMapping(value = "/category")
    public JSONObject category(){
        log.info("      category 실행");
        Set<String> categorylist = new HashSet<>();
        JSONObject jsonObject = new JSONObject();
        for(Annotation a: annotationReposiroty.findAll()) categorylist.add(a.convertDTO().getCategory());
        log.info("      category 목록 ==> " + categorylist);
        jsonObject.put("category",categorylist);
        return jsonObject;
    }

    @RequestMapping(value = "/label_name" ,method = RequestMethod.POST)
    public JSONObject category(@RequestBody JSONObject jsonObject){
        JSONObject jsonObject1 = new JSONObject();
        List<String> labelNAMEList = new ArrayList<>();
        String category = (String) jsonObject.get("category");
        log.info("      입력으로 들어온 카테고리는 : " + category);
        List<Annotation> annotationList = annotationReposiroty.findByCategory(category);
        for(Annotation a : annotationList) labelNAMEList.add(a.convertDTO().getLabelNAME());
        log.info("      label_name ==> "+labelNAMEList);
        jsonObject1.put("label_names",labelNAMEList);
        return jsonObject1;
    }
}
