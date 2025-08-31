package com.fatma.demo.service;

import com.fatma.demo.dto.request.UserRequest;
import com.fatma.demo.dto.response.UserResponse;
import com.fatma.demo.model.User;
import com.fatma.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setMessage("Başarıyla kaydedildi");

        return userResponse;
    }
}
