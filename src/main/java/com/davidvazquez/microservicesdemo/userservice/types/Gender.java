package com.davidvazquez.microservicesdemo.userservice.types;

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
}