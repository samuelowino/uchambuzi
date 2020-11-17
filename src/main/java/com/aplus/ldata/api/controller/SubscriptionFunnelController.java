package com.aplus.ldata.api.controller;

import com.aplus.ldata.api.controller.base.ApiConstants;
import com.aplus.ldata.api.controller.base.ApiResponse;
import com.aplus.ldata.api.controller.base.GenericController;
import com.aplus.ldata.api.database.SubscriptionFunnel;
import com.aplus.ldata.api.database.repository.SubscriptionFunnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController(ApiConstants.BASE_URL + "/subs/funnel")
public class SubscriptionFunnelController implements GenericController<SubscriptionFunnel> {

    @Autowired
    private SubscriptionFunnelRepository repository;

    @PostMapping("/")
    @Override
    public ApiResponse<Boolean> create(SubscriptionFunnel data) {
        repository.save(data);
        return new ApiResponse<>(true, "Success.");
    }

    @DeleteMapping("/")
    @Override
    public ApiResponse<Boolean> delete(SubscriptionFunnel data) {
        repository.delete(data);
        return new ApiResponse<>(true, "Success.");
    }

    @GetMapping("/")
    @Override
    public ApiResponse<List<SubscriptionFunnel>> getAll(SubscriptionFunnel data) {
        List<SubscriptionFunnel> dataList = repository.findAll();
        return new ApiResponse<List<SubscriptionFunnel>>(dataList, "Success.");
    }

    @GetMapping("/{uuid}/")
    @Override
    public ApiResponse<SubscriptionFunnel> find(String uuid) {
        Optional<SubscriptionFunnel> optionsData = repository.findByUuid(uuid);
        SubscriptionFunnel data = optionsData.get();
        return new ApiResponse<>(data, "Complete");
    }
}
