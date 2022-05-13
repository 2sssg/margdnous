package com.example.margdnous.controller;

import com.example.margdnous.model.Annotation;
import com.example.margdnous.repository.AnnotationReposiroty;
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
public class Controller {
    @Autowired
    AnnotationReposiroty annotationReposiroty;

    @RequestMapping(value = "/category")
    public JSONObject category(){
        List<Annotation> annotationList = annotationReposiroty.findAll();
        Set<String> categorylist = new HashSet<>();
        JSONObject jsonObject = new JSONObject();
        for(Annotation a : annotationList) categorylist.add(a.getCategory());
        jsonObject.put("category",categorylist);
        return jsonObject;
    }

    @RequestMapping(value = "/label_name" ,method = RequestMethod.POST)
    public JSONObject category(@RequestBody JSONObject jsonObject){
        JSONObject jsonObject1 = new JSONObject();
        String category = (String) jsonObject.get("category");
        System.out.println(category);
        List<String> labelNAMEs = new ArrayList<>();
        List<Annotation> annotationList = annotationReposiroty.findByCategory(category);
        for(Annotation a : annotationList){
            labelNAMEs.add(a.getLabelNAME());
        }
        jsonObject1.put("label_names",labelNAMEs);
        return jsonObject1;
    }



}
