package com.springboot.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.docker.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
