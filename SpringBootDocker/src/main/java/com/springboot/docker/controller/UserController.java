package com.springboot.docker.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpSession;
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

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        System.out.println("/user/get/" + getHostInfo());
        User user = userRepository.getOne(id);
        System.out.println(user);
        return new User(user.getId(), getHostInfo(), user.getAge());
    }

    @Transactional
    @GetMapping(path = "/create")
    @ResponseBody
    public User create(User user) {
        System.out.println("/user/post/" + getHostInfo());
        System.out.println(user);
        userRepository.save(user);
        user.setName(getHostInfo());
        return user;
    }

    @GetMapping(path = "/rd")
    public User rd(@RequestParam("url") String url) {
        System.out.println("/user/get/id/" + url);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<User> ret = restTemplate.getForEntity(url, User.class);
        System.out.println(ret.getBody());
        ret.getBody().setName(getHostInfo());
        return ret.getBody();
    }

    @GetMapping(path = "/hc")
    public int hc() {
        return 200;
    }

    @GetMapping(path = "/setsession")
    public void setSession(HttpSession session, String key, String value) {
        if (session == null) {
            log.info("session is null");
            return;
        }

        session.setAttribute(key, value);
    }

    @GetMapping(path = "/getsession")
    public void getSession(HttpSession session, String key) {
        if (session == null) {
            log.info("session is null");
            return;
        }

        Object value = session.getAttribute(key);
        log.info("value = " + value);
    }

    private String getHostInfo() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostName() + "-" + inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

}
