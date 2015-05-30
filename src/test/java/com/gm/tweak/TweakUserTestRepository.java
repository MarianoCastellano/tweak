package com.gm.tweak;

import java.util.HashMap;
import java.util.Map;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.repository.TweakUserRepository;

public class TweakUserTestRepository implements TweakUserRepository {

	private Map<Long, TweakUser> tweakUsers;

	public TweakUserTestRepository() {
		tweakUsers = new HashMap<Long, TweakUser>();
	}

	@Override
	public TweakUser save(TweakUser tweakUser) {

		TweakUser savedTweakUser = null;

		for (long i = 0; i < 10; i++) {
			if (!tweakUsers.containsKey(i)) {
				tweakUsers.put(i, tweakUser);
				tweakUser.assignId(i);
				savedTweakUser = tweakUser;
			}
		}
		return savedTweakUser;
	}

	@Override
	public TweakUser findById(Long id) {
		return tweakUsers.get(id);
	}

}
