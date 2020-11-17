package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.controller.base.ApiResponse;
import com.aplus.ldata.api.controller.base.GenericController;
import com.aplus.ldata.api.database.GeneralModuleStats;
import com.aplus.ldata.api.database.repository.GeneralModuleStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController(ApiConstants.BASE_URL + "/module/stats")
public class GeneralModuleStatsController implements GenericController<GeneralModuleStats> {

    @Autowired
    private GeneralModuleStatsRepository repository;

    @PostMapping("/")
    @Override
    public ApiResponse<Boolean> create(GeneralModuleStats data) {
        repository.save(data);
        return new ApiResponse<>(true, "Success.");
    }

    @DeleteMapping("/")
    @Override
    public ApiResponse<Boolean> delete(GeneralModuleStats data) {
        repository.delete(data);
        return new ApiResponse<>(true, "Success.");
    }

    @GetMapping("/")
    @Override
    public ApiResponse<List<GeneralModuleStats>> getAll(GeneralModuleStats data) {
        List<GeneralModuleStats> dataList = repository.findAll();
        return new ApiResponse<List<GeneralModuleStats>>(dataList, "Success.");
    }

    @GetMapping("/{uuid}/")
    @Override
    public ApiResponse<GeneralModuleStats> find(String uuid) {
        Optional<GeneralModuleStats> optionsData = repository.findByUuid(uuid);
        GeneralModuleStats data = optionsData.get();
        return new ApiResponse<>(data, "Complete");
    }
}
