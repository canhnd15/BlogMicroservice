package com.davidblog.users.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/test")
    public String test(){
        return "Test";
    }
}
