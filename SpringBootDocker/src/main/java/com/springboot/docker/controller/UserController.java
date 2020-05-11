package com.springboot.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.docker.domain.User;

@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping
    public User get(Integer id) {
        System.out.println("/user/get");
        User user = new User();
        user.setName("name");
        return user;
    }

}
