package com.teamsync.teamsync_backend.service;

import com.teamsync.teamsync_backend.entity.User;
import com.teamsync.teamsync_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}