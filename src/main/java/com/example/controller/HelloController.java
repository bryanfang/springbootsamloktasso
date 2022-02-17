package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Map<String, String> hello(@RequestHeader Map<String, String> header) {
        return header;
    }
}
