package com.davidvazquez.user.userservice.vo;

import com.davidvazquez.user.userservice.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithDepartment {
    private User user;
    private Department department;
}
