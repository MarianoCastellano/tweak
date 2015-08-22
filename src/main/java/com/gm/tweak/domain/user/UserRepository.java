package com.gm.tweak.domain.user;

import com.gm.tweak.domain.user.User;
import com.gm.tweak.exception.UserNotFoundException;

public interface UserRepository {

	public User save(User user);

	public User findById(String id) throws Exception;

	public User findByEmail(String email) throws UserNotFoundException;

	public String getId();

}
