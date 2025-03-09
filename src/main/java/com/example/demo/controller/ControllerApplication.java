package com.example.demo.controller;

import com.example.demo.model.Information;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class ControllerApplication {

    @GetMapping(value = "/user")
    public ResponseEntity<Information> getInfo() {
        Information info = Information.builder().name("Alex").age(12).build();
        return ResponseEntity.ok().body(info);
    }
}
