package com.kx.gateway.service.instance.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kx.gateway.service.instance.dto.ServiceInstance;
import com.kx.gateway.service.instance.dto.StatusResponse;
import com.kx.gateway.service.instance.service.InstanceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
class ServiceInstanceController {

    private final InstanceService instanceService;

    @GetMapping("/status")
    public StatusResponse serviceInstancesByApplicationName() {
        final List<ServiceInstance> availableInstances = instanceService.getInstances("STORAGE-SERVICE");
        return new StatusResponse(availableInstances);
    }
}