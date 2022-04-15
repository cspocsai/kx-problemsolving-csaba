package com.kx.gateway.service.instance.dto;

import com.netflix.appinfo.InstanceInfo;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ServiceInstance {

    private String appName;
    private String instanceId;
    private String hostname;
    private InstanceInfo.InstanceStatus status;

}
