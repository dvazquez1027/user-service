package com.davidvazquez.microservicesdemo.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
}
