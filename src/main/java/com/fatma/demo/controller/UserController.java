package com.fatma.demo.controller;

import com.fatma.demo.model.User;
import com.fatma.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/create")
    public User createUser (@RequestBody User user){
        return userService.createUser(user);
    }
}
