package org.example.educationsystembackend.controller;

import org.example.educationsystembackend.entity.SurveyRequest;
import org.example.educationsystembackend.entity.SurveyResponse;
import org.example.educationsystembackend.mapper.PersonalInfoMapper;
import org.example.educationsystembackend.mapper.SurveyRequestMapper;
import org.example.educationsystembackend.mapper.SurveyResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveyResponse")
@CrossOrigin
public class SurveyResponseController {
    @Autowired
    SurveyResponseMapper surveyResponseMapper;
    @Autowired
    PersonalInfoMapper personalInfoMapper;
    @Autowired
    SurveyRequestMapper surveyRequestMapper;

    @PostMapping("/insert")
    public String insert(@RequestBody SurveyRequest surveyRequest){
        personalInfoMapper.insertPersonalInfo(surveyRequest.getPersonalInfo());
        Integer userId = surveyRequest.getPersonalInfo().getUserId();
        for (SurveyResponse surveyResponse : surveyRequest.getSurveyResponses()){
            surveyResponse.setUserId(userId);
            surveyResponseMapper.insertSurveyResponse(surveyResponse);
        }
        return "success";
    }

    @GetMapping("/getAll")
    public List<SurveyRequest> getAll(){

        return surveyRequestMapper.findAllSurveyRequests();
    }
}
