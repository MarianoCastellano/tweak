package com.gm.tweak.service;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.repository.TweakUserRepository;

public class TweakUserRegisterService {

	private TweakUserRepository tweakUserRepository;

	public TweakUserRegisterService(TweakUserRepository tweakUserRepository) {
		this.tweakUserRepository = tweakUserRepository;
	}

	public TweakUser register(String email, String username) {
		return tweakUserRepository.save(new TweakUser(email, username));
	}

}
