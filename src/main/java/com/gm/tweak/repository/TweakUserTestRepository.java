package com.gm.tweak.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.gm.tweak.domain.TweakUser;

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
	public TweakUser findById(Long id) {
		return tweakUsers.get(id);
	}

}
