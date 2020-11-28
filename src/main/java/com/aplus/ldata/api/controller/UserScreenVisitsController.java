package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.controller.base.ApiResponse;
import com.aplus.ldata.api.controller.base.GenericController;
import com.aplus.ldata.api.database.UserScreenVisits;
import com.aplus.ldata.api.database.repository.UserScreenVisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(ApiConstants.BASE_URL + "/user/screens")
@RestController
public class UserScreenVisitsController implements GenericController<UserScreenVisits> {

    @Autowired
    private UserScreenVisitsRepository repository;

    @PostMapping("/")
    @Override
    public ApiResponse<Boolean> create(@RequestBody UserScreenVisits data) {
        repository.save(data);
        return new ApiResponse<>(true, "Success.");
    }

    @GetMapping("/")
    @Override
    public ApiResponse<List<UserScreenVisits>> getAll() {
        List<UserScreenVisits> dataList = repository.findAll();
        return new ApiResponse<List<UserScreenVisits>>(dataList, "Success.");
    }

    @GetMapping("/{uuid}/")
    @Override
    public ApiResponse<UserScreenVisits> find(@PathVariable String uuid) {
        Optional<UserScreenVisits> optionsData = repository.findByUuid(uuid);
        UserScreenVisits data = optionsData.get();
        return new ApiResponse<>(data, "Complete");
    }
}
