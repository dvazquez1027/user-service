package com.davidvazquez.microservicesdemo.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithDepartmentDTO {
    private UserDTO user;
    private DepartmentDTO department;
}
