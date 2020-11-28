package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.controller.base.ApiResponse;
import com.aplus.ldata.api.controller.base.GenericController;
import com.aplus.ldata.api.database.GeneralModuleStats;
import com.aplus.ldata.api.database.repository.GeneralModuleStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GeneralModuleStatsRepository repository;

    @PostMapping("/")
    @Override
    public ApiResponse<Boolean> create(@RequestBody GeneralModuleStats data) {
        repository.save(data);
        return new ApiResponse<>(true, "Success.");
    }

    @GetMapping("/")
    @Override
    public ApiResponse<List<GeneralModuleStats>> getAll() {
        List<GeneralModuleStats> dataList = repository.findAll();
        return new ApiResponse<List<GeneralModuleStats>>(dataList, "Success.");
    }

    @GetMapping("/{uuid}/")
    @Override
    public ApiResponse<GeneralModuleStats> find(@PathVariable String uuid) {
        Optional<GeneralModuleStats> optionsData = repository.findByUuid(uuid);
        GeneralModuleStats data = optionsData.get();
        return new ApiResponse<>(data, "Complete");
    }
}
