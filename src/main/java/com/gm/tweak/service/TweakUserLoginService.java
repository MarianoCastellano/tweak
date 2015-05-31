package com.gm.tweak.service;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.exception.InvalidPasswordException;
import com.gm.tweak.exception.UserNotFoundException;
import com.gm.tweak.repository.TweakUserRepository;

public class TweakUserLoginService {

	private TweakUserRepository tweakUserRepository;

	public TweakUserLoginService(TweakUserRepository tweakUserRepository) {
		this.tweakUserRepository = tweakUserRepository;
	}

	public TweakUser login(String email, String password) throws UserNotFoundException, InvalidPasswordException {

		TweakUser tweakUser = tweakUserRepository.findByEmail(email);

		if (password.equals(tweakUser.getPassword())) {
			return tweakUser;
		}
		throw new InvalidPasswordException("INVALID PASSWORD");
	}
}
