package com.gm.tweak.repository;

import com.gm.tweak.domain.User;
import com.gm.tweak.exception.UserNotFoundException;

public interface UserRepository {

	public User save(User user);

	public User findById(Long id) throws Exception;

	public User findByEmail(String email) throws UserNotFoundException;

}
