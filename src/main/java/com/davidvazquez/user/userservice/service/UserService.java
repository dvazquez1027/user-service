package com.davidvazquez.user.userservice.service;

import com.davidvazquez.user.userservice.entity.User;
import com.davidvazquez.user.userservice.repository.UserRepository;
import com.davidvazquez.user.userservice.vo.Department;
import com.davidvazquez.user.userservice.vo.UserWithDepartment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private UserRepository userRepository;
    private RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public UserWithDepartment findByIdWithDepartment(Long userId) {
        User user = userRepository.findById(userId).get();
        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);
        return new UserWithDepartment(user, department);
    }
}
