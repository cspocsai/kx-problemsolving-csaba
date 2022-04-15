package com.kx.storage.service.employee.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("Employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeModel implements Serializable {

    private String id;
    private String name;
    private String address;
    private String sex;
    private String phoneNumber;
    private String position;
    private String title;
    private LocalDateTime creationDate;

}