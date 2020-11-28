package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.controller.base.ApiResponse;
import com.aplus.ldata.api.controller.base.GenericController;
import com.aplus.ldata.api.database.ExitScreen;
import com.aplus.ldata.api.database.repository.ExitScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(ApiConstants.BASE_URL + "/screen")
@RestController
public class ExitScreenController implements GenericController<ExitScreen> {

    @Autowired
    private ExitScreenRepository repository;

    @PostMapping("/")
    @Override
    public ApiResponse<Boolean> create(@RequestBody ExitScreen data) {
        repository.save(data);
        return new ApiResponse<>(true, "Success.");
    }

    @GetMapping("/")
    @Override
    public ApiResponse<List<ExitScreen>> getAll() {
        List<ExitScreen> dataList = repository.findAll();
        return new ApiResponse<List<ExitScreen>>(dataList, "Success.");
    }

    @GetMapping("/{uuid}/")
    @Override
    public ApiResponse<ExitScreen> find(@PathVariable String uuid) {
        Optional<ExitScreen> optionsData = repository.findByUuid(uuid);
        ExitScreen data = optionsData.get();
        return new ApiResponse<>(data, "Complete");
    }
}

