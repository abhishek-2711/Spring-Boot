package com.codingshuttle.cachingApp.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String email;
    private String name;
    private Long salary;
}
