package com.gm.tweak.repository;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.exception.UserNotFoundException;

public interface TweakUserRepository {

	public TweakUser save(TweakUser tweakUser);

	public TweakUser findById(Long id) throws Exception;

	public TweakUser findByEmail(String email) throws UserNotFoundException;

}
