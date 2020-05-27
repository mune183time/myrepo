package com.springboot.docker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

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

}
