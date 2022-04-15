package com.kx.storage.service.employee.model.dto;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class Employee {

    private String name;
    private String address;
    private String sex;
    private String phoneNumber;
    private String position;
    private String title;

}