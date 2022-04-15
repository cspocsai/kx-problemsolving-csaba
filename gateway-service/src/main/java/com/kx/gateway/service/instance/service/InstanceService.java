package com.kx.gateway.service.instance.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kx.gateway.service.instance.dto.ServiceInstance;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstanceService {

    private final EurekaClient eurekaClient;

    public List<ServiceInstance> getInstances(final String appName) {
        final Application application = eurekaClient.getApplications().getRegisteredApplications(appName);
        if (Objects.isNull(application)) {
            return Collections.emptyList();
        }
        return application.getInstances().stream().map(this::toServiceInstance).collect(Collectors.toList());
    }

    private ServiceInstance toServiceInstance(final InstanceInfo instanceInfo) {
        return ServiceInstance.builder()
                .instanceId(instanceInfo.getInstanceId())
                .appName(instanceInfo.getAppName())
                .hostname(instanceInfo.getHostName())
                .status(instanceInfo.getStatus())
                .build();
    }
}
