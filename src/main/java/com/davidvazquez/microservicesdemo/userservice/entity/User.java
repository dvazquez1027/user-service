package com.davidvazquez.microservicesdemo.userservice.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public enum Gender {
        MALE("M", "Male"),
        FEMALE("F", "Female");

        private final String name;
        private final String description;

        private Gender(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
