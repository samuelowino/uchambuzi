package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.controller.base.ApiResponse;
import com.aplus.ldata.api.controller.base.GenericController;
import com.aplus.ldata.api.database.SubscriptionFunnel;
import com.aplus.ldata.api.database.repository.SubscriptionFunnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(ApiConstants.BASE_URL + "/subs/funnel")
@RestController
public class SubscriptionFunnelController implements GenericController<SubscriptionFunnel> {

    @Autowired
    private SubscriptionFunnelRepository repository;

    @PostMapping("/")
    @Override
    public ApiResponse<Boolean> create(@RequestBody SubscriptionFunnel data) {
        repository.save(data);
        return new ApiResponse<>(true, "Success.");
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<SubscriptionFunnel> getAll() {
        List<SubscriptionFunnel> dataList = repository.findAll();
        return dataList;
    }

    @GetMapping("/{uuid}/")
    @Override
    public ApiResponse<SubscriptionFunnel> find(@PathVariable String uuid) {
        Optional<SubscriptionFunnel> optionsData = repository.findByUuid(uuid);
        SubscriptionFunnel data = optionsData.get();
        return new ApiResponse<>(data, "Complete");
    }
}
