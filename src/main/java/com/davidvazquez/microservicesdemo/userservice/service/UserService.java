package com.davidvazquez.microservicesdemo.userservice.service;

import com.davidvazquez.microservicesdemo.userservice.dto.DepartmentDTO;
import com.davidvazquez.microservicesdemo.userservice.dto.UserDTO;
import com.davidvazquez.microservicesdemo.userservice.dto.UserWithDepartmentDTO;
import com.davidvazquez.microservicesdemo.userservice.entity.User;
import com.davidvazquez.microservicesdemo.userservice.repository.UserRepository;

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

    public User saveUser(UserDTO userDTO) {
        return userRepository.save(UserDTO.toEntity(userDTO));
    }

    public UserDTO findUserById(Long userId) {
        return UserDTO.fromEntity(userRepository.findById(userId).get());
    }

    public UserWithDepartmentDTO findByIdWithDepartment(Long userId) {
        User user = userRepository.findById(userId).get();
        DepartmentDTO department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), DepartmentDTO.class);
        return new UserWithDepartmentDTO(UserDTO.fromEntity(user), department);
    }
}
