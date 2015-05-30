package com.gm.tweak.repository;

import com.gm.tweak.domain.TweakUser;

public interface TweakUserRepository {

	public TweakUser save(TweakUser tweakUser);

	public TweakUser findById(Long id);

}
