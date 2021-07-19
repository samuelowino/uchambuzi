package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.controller.base.ApiResponse;
import com.aplus.ldata.api.controller.base.GenericController;
import com.aplus.ldata.api.database.UserFeatureActions;
import com.aplus.ldata.api.database.repository.UserFeatureActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(ApiConstants.BASE_URL + "/user/features/actions")
@RestController
public class UserFeatureActionsController implements GenericController<UserFeatureActions> {

    @Autowired
    private UserFeatureActionsRepository repository;

    @PostMapping("/")
    @Override
    public ApiResponse<Boolean> create(UserFeatureActions data) {
        repository.save(data);
        return new ApiResponse<>(true, "Success.");
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<UserFeatureActions> getAll() {
        List<UserFeatureActions> dataList = repository.findAll();
        return dataList;
    }

    @GetMapping("/{uuid}/")
    @Override
    public ApiResponse<UserFeatureActions> find(@PathVariable String uuid) {
        Optional<UserFeatureActions> optionsData = repository.findByUuid(uuid);
        UserFeatureActions data = optionsData.get();
        return new ApiResponse<>(data, "Complete");
    }
}
