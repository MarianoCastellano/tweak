package com.gm.tweak.service;

import com.gm.tweak.domain.User;
import com.gm.tweak.repository.UserRepository;

public class UserRegisterService {

	private UserRepository userRepository;

	public UserRegisterService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User register(String email, String username, String password) {
		return userRepository.save(new User(userRepository.getId(),email, username, password));
	}

}
