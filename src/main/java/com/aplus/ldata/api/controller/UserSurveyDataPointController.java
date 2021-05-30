package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.database.UserSurveyData;
import com.aplus.ldata.api.database.repository.UserSurveyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.BASE_URL + "/survey")
public class UserSurveyDataPointController {

    @Autowired
    private UserSurveyDataRepository dataRepository;

    @PostMapping("/")
    public void create(@RequestBody List<UserSurveyData> data) {
        dataRepository.saveAll(data);
    }
}
