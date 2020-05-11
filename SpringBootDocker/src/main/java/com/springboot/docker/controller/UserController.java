package com.springboot.docker.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.docker.domain.User;
import com.springboot.docker.repository.UserRepository;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public User get(Integer id) {
        System.out.println("/user/get");
        User user = userRepository.getOne(id);
        return user;
    }

    @Transactional
    @PostMapping
    public User get(User user) {
        System.out.println("/user/post");
        System.out.println(user);
        userRepository.save(user);
        return user;
    }

}
