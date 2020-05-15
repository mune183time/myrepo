package com.springboot.docker.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.docker.domain.User;
import com.springboot.docker.repository.UserRepository;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //    @Autowired
    //    private RestTemplate restTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping
    public User get(Integer id) {
        System.out.println("/user/get/" + id);
        User user = userRepository.getOne(id);
        System.out.println(user);
        return new User(user.getId(), user.getName(), user.getAge());
    }

    @Transactional
    @GetMapping(path = "/create")
    @ResponseBody
    public User create(User user) {
        System.out.println("/user/post" + user.getName());
        System.out.println(user);
        userRepository.save(user);
        return user;
    }

    @GetMapping(path = "/rd")
    public User rd(@RequestParam("url") String url) {
        System.out.println("/user/get/id/" + url);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<User> ret = restTemplate.getForEntity(url, User.class);
        System.out.println(ret.getBody());
        return ret.getBody();
    }

    @GetMapping(path = "/hc")
    public int hc() {
        return 200;
    }

}
