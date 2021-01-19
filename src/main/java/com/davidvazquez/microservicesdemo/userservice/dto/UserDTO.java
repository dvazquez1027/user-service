package com.davidvazquez.microservicesdemo.userservice.dto;

import java.util.Date;

import com.davidvazquez.microservicesdemo.userservice.entity.User;
import com.davidvazquez.microservicesdemo.userservice.types.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Date dateOfBirth;
    private Gender gender;
    private Long departmentId;

    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getMiddleInitial(),
                userDTO.getAddress(), userDTO.getCity(), userDTO.getState(), userDTO.getZip(),
                new java.sql.Date(userDTO.getDateOfBirth().getTime()), userDTO.getGender(), userDTO.getDepartmentId());
    }

    public static UserDTO fromEntity(User user) {
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getMiddleInitial(),
                user.getAddress(), user.getCity(), user.getState(), user.getZip(),
                new Date(user.getDateOfBirth().getTime()), user.getGender(), user.getDepartmentId());
    }
}
