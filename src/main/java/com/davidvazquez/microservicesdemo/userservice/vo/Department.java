package com.davidvazquez.microservicesdemo.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
}
