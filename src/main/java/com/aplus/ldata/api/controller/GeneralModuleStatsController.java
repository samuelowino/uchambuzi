package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.controller.base.ApiResponse;
import com.aplus.ldata.api.controller.base.GenericController;
import com.aplus.ldata.api.database.GeneralModuleStats;
import com.aplus.ldata.api.database.repository.GeneralModuleStatsRepository;
import com.aplus.ldata.api.resource.ModuleStatsResource;
import com.aplus.ldata.constants.ModuleConstants;
import com.fasterxml.jackson.databind.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(ApiConstants.BASE_URL + "/module/stats")
@RestController
public class GeneralModuleStatsController implements GenericController<GeneralModuleStats> {

    private static Logger LOGGER = LoggerFactory.getLogger(GeneralModuleStatsController.class.getSimpleName());

    @Autowired
    private GeneralModuleStatsRepository repository;

    @PostMapping("/")
    @Override
    public ApiResponse<Boolean> create(@RequestBody GeneralModuleStats data) {
        repository.save(data);
        return new ApiResponse<>(true, "Success.");
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<GeneralModuleStats> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/summary/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModuleStatsResource getModuleStatsSummary() {
        int habitCount = repository.getModuleStatsByName(ModuleConstants.HABIT_MODULE).size();
        int financeCount = repository.getModuleStatsByName(ModuleConstants.FINANCE_MODULE).size();
        int wellnessCount = repository.getModuleStatsByName(ModuleConstants.WELLNESS_MODULE).size();
        int productivityCount = repository.getModuleStatsByName(ModuleConstants.PRODUCTIVITY_MODULE).size();
        return new ModuleStatsResource(habitCount, productivityCount, financeCount, wellnessCount);
    }


    @GetMapping("/{uuid}/")
    @Override
    public ApiResponse<GeneralModuleStats> find(@PathVariable String uuid) {
        Optional<GeneralModuleStats> optionsData = repository.findByUuid(uuid);
        GeneralModuleStats data = optionsData.get();
        return new ApiResponse<>(data, "Complete");
    }
}
