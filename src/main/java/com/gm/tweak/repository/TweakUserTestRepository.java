package com.gm.tweak.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.exception.UserNotFoundException;

public class TweakUserTestRepository implements TweakUserRepository {

	private Map<Long, TweakUser> tweakUsers;

	public TweakUserTestRepository() {
		tweakUsers = new HashMap<Long, TweakUser>();
	}

	@Override
	public TweakUser save(TweakUser tweakUser) {
		long id = UUID.randomUUID().getMostSignificantBits();
		tweakUser.assignId(id);
		tweakUsers.put(id, tweakUser);
		return tweakUser;
	}

	@Override
	public TweakUser findById(Long id) throws Exception {
		TweakUser tweakUser = tweakUsers.get(id);
		if (tweakUser == null) {
			throw new Exception("USER NOT FOUND");
		}
		return tweakUser;
	}

	@Override
	public TweakUser findByEmail(String email) throws UserNotFoundException {
		for (TweakUser tweakUser : tweakUsers.values()) {
			if (email.equals(tweakUser.getEmail())) {
				return tweakUser;
			}
		}
		throw new UserNotFoundException("USER NOT FOUND");
	}
}
