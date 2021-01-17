package com.davidvazquez.microservicesdemo.userservice.repository;

import com.davidvazquez.microservicesdemo.userservice.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
