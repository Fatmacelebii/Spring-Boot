package com.fatma.demo.controller;

import com.fatma.demo.dto.request.UserRequest;
import com.fatma.demo.dto.response.UserResponse;
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
    public UserResponse createUser (@RequestBody UserRequest request){
        return userService.createUser(request);
    }
}
