package com.example.demo.controller;

import com.example.demo.model.Information;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/info/user")
public class ControllerApplication {
    @GetMapping

    public Information  getInfo() {
        return Information.builder().name("Alex").age(12).build();
    }
}
