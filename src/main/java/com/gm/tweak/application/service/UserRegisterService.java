package com.gm.tweak.application.service;

import com.gm.tweak.domain.user.User;
import com.gm.tweak.domain.user.UserRepository;

public class UserRegisterService {

    private UserRepository userRepository;

    public UserRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String email, String username, String password) {
        return userRepository.save(new User(userRepository.getId(), email, username, password));
    }

}
