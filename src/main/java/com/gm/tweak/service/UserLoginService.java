package com.gm.tweak.service;

import com.gm.tweak.domain.User;
import com.gm.tweak.exception.InvalidPasswordException;
import com.gm.tweak.exception.UserNotFoundException;
import com.gm.tweak.repository.UserRepository;

public class UserLoginService {

	private UserRepository userRepository;

	public UserLoginService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User login(String email, String password)
			throws UserNotFoundException, InvalidPasswordException {

		User user = userRepository.findByEmail(email);

		if (password.equals(user.getPassword())) {
			return user;
		}
		throw new InvalidPasswordException("INVALID PASSWORD");
	}
}
