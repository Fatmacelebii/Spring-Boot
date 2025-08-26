package com.fatma.demo.service;

import com.fatma.demo.model.User;
import com.fatma.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();

    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
