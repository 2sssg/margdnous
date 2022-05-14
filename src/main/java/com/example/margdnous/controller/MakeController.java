package com.example.margdnous.controller;

import com.example.margdnous.DTO.AnnotationDTO;
import com.example.margdnous.model.Annotation;
import com.example.margdnous.model.InputData;
import com.example.margdnous.model.senario.*;
import com.example.margdnous.model.unityjson.json1.Labels_json;
import com.example.margdnous.model.unityjson.json2.Sementic_json;
import com.example.margdnous.model.unityjson.json3.Random_json;
import com.example.margdnous.repository.AnnotationReposiroty;
import com.example.margdnous.repository.InputDataRepository;
import com.example.margdnous.repository.senario.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("/make")
@Slf4j
public class MakeController {
    @Autowired
    AnnotationReposiroty annotationReposiroty;
    @Autowired
    InputDataRepository inputDataRepository;
    @Autowired
    XRepository xRepository;
    @Autowired
    YRepository yRepository;
    @Autowired
    ZRepository zRepository;
    @Autowired
    HueRepository hueRepository;
    @Autowired
    SunAngleRepository sunAngleRepository;
    @Autowired
    SenarioRepository senarioRepository;


    public MultiValueMap<String,String> unity(String labelname, X x, Y y, Z z, Hue h, SunAngle s) throws SQLException, JsonProcessingException {
        log.info("      temp 실행");
        JSONObject jsonObject = new JSONObject();
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        Gson gson = new Gson();
        String t = gson.toJson(new Labels_json(labelname));
        param.add("labels_json",t);
        t = gson.toJson(new Sementic_json(labelname));
        param.add("semantic_json",t);
        t = gson.toJson(new Random_json(x.getMax(), x.getMin(),  y.getMax(),  y.getMin() ,  z.getMax(),  z.getMin(),  h.getMax(),  h.getMin(), s.getHour() ,  s.getDayOfYear(),  s.getLatitude()));
        param.add("random_json",t);

        ObjectMapper mapper = new ObjectMapper();
//        param.add("label_json",new Labels_json(labelname).toString());
//        param.add("sementic_json",new Sementic_json(labelname).toString());
//        param.add("random_json",new Random_json(x.getMax(), x.getMin(),  y.getMax(),  y.getMin() ,  z.getMax(),  z.getMin(),  h.getMax(),  h.getMin(), s.getHour() ,  s.getDayOfYear(),  s.getLatitude()).toString());
//        jsonObject.put("label_json",new Labels_json(labelname));
//        jsonObject.put("sementic_json",new Sementic_json(labelname));
//        jsonObject.put("random_json",new Random_json(x.getMax(), x.getMin(),  y.getMax(),  y.getMin() ,  z.getMax(),  z.getMin(),  h.getMax(),  h.getMin(), s.getHour() ,  s.getDayOfYear(),  s.getLatitude()));

        log.info("dassadasdasdadsasdsda");
        return param;
    }

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
    public JSONObject labelName(@RequestBody JSONObject jsonObject){
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

    @RequestMapping(value="/send_data", method = RequestMethod.POST)
    public JSONObject sendData(@RequestBody JSONObject inputData) throws SQLException, JsonProcessingException, ParseException {
        JSONObject returnObject = new JSONObject();
        X x = new X();
        Y y = new Y();
        Z z = new Z();
        Hue hue = new Hue();
        SunAngle sunAngle = new SunAngle();
        Senario senario = new Senario();
        InputData inputdata = new InputData();
        x.setMin(Integer.parseInt((String)inputData.get("x_min")));
        x.setMax(Integer.parseInt((String)inputData.get("x_max")));
        xRepository.save(x);
        y.setMin(Integer.parseInt((String)inputData.get("y_min")));
        y.setMax(Integer.parseInt((String)inputData.get("y_max")));
        yRepository.save(y);
        z.setMin(Integer.parseInt((String)inputData.get("z_min")));
        z.setMax(Integer.parseInt((String)inputData.get("z_max")));
        zRepository.save(z);
        hue.setMin(Integer.parseInt((String)inputData.get("hue_min")));
        hue.setMax(Integer.parseInt((String)inputData.get("hue_max")));
        hueRepository.save(hue);
        sunAngle.setHour(Integer.parseInt((String)inputData.get("sunAngle_hour")));
        sunAngle.setDayOfYear(Integer.parseInt((String)inputData.get("sunAngle_doy")));
        sunAngle.setLatitude(Integer.parseInt((String)inputData.get("sunAngle_latitude")));
        sunAngleRepository.save(sunAngle);
        senario.setX(x);
        senario.setY(y);
        senario.setZ(z);
        senario.setHue(hue);
        senario.setSunAngle(sunAngle);
        senarioRepository.save(senario);
        inputdata.setLabelNameList(inputData.get("label_names").toString().replaceAll("[\\[\\]]",""));
        inputdata.setSenario(senario);
        inputdata.setMyDataKey(Math.abs(new Date().hashCode()));

        returnObject.put("myDataKey",inputdata.getMyDataKey());

        inputDataRepository.save(inputdata);

        MultiValueMap<String, String> param = unity(inputdata.getLabelNameList().replaceAll(" ",""),x,y,z,hue,sunAngle);
//        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
//        param.add("test","test");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE,"application/json");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(param, headers);
        RestTemplate rt = new RestTemplate();
        log.info(param.toString());
        ResponseEntity<String> response = rt.exchange(
                "http://210.216.225.171:5000/unity_job", //{요청할 서버 주소}
                HttpMethod.POST, //{요청할 방식}
                entity, // {요청할 때 보낼 데이터}
                String.class
        );
        inputdata.setEnd(true);

        JSONParser parser = new JSONParser();
        Object obj = parser.parse( response.getBody() );
        JSONObject jsonObj = (JSONObject) obj;
        inputdata.setUrl((String) jsonObj.get("data_url"));
        inputDataRepository.save(inputdata);
        log.info(response.toString());
        return returnObject;
    }
}
