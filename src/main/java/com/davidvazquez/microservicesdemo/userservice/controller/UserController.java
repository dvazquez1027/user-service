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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO user) {
        log.info("Entering UserController.createUser");
        UserDTO result = userService.saveUser(user);
        log.info("Exiting UserController.createUser");
        return result;
    }

    @GetMapping("/{id}")
    public UserDTO readUser(@PathVariable("id") Long userId) {
        log.info("Entering UserController.readUser");
        UserDTO result = userService.findUserById(userId);
        log.info("Exiting UserController.readUser");
        return result;
    }

    @GetMapping("/{id}/department")
    public UserWithDepartmentDTO readUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Entering UserController.readUsreWithDepartment");
        UserWithDepartmentDTO result = userService.findByIdWithDepartment(userId);
        log.info("Exiting UserController.readUserWithDepartment");
        return result;
    }
}
