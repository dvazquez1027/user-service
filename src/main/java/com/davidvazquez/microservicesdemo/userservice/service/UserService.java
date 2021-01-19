package com.davidvazquez.microservicesdemo.userservice.service;

import com.davidvazquez.microservicesdemo.userservice.dto.DepartmentDTO;
import com.davidvazquez.microservicesdemo.userservice.dto.UserDTO;
import com.davidvazquez.microservicesdemo.userservice.dto.UserWithDepartmentDTO;
import com.davidvazquez.microservicesdemo.userservice.entity.User;
import com.davidvazquez.microservicesdemo.userservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    private UserRepository userRepository;
    private RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        log.info("Entering UserService.saveUser");
        UserDTO result = UserDTO.fromEntity(userRepository.save(UserDTO.toEntity(userDTO)));
        log.info("Exiting UserService.saveUser");
        return result;
    }

    public UserDTO findUserById(Long userId) {
        log.info("Entering UserService.findUserById");
        UserDTO result = UserDTO.fromEntity(userRepository.findById(userId).get());
        log.info("Exiting UserService.findUserById");
        return result;
    }

    public UserWithDepartmentDTO findByIdWithDepartment(Long userId) {
        log.info("Entering UserService.findByIdWithDepartment");
        User user = userRepository.findById(userId).get();
        DepartmentDTO department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), DepartmentDTO.class);
        UserWithDepartmentDTO result = new UserWithDepartmentDTO(UserDTO.fromEntity(user), department);
        log.info("Exiting UserService.findByIdWithDepartment");
        return result;
    }
}
