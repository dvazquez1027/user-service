package com.davidvazquez.microservicesdemo.userservice.controller;

import com.davidvazquez.microservicesdemo.userservice.dto.UserDTO;
import com.davidvazquez.microservicesdemo.userservice.dto.UserWithDepartmentDTO;
import com.davidvazquez.microservicesdemo.userservice.entity.User;
import com.davidvazquez.microservicesdemo.userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserDTO readUser(@PathVariable("id") Long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/{id}/department")
    public UserWithDepartmentDTO readUserWithDepartment(@PathVariable("id") Long userId) {
        return userService.findByIdWithDepartment(userId);
    }
}
