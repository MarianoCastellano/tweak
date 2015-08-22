package com.gm.tweak.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.gm.tweak.domain.user.User;
import com.gm.tweak.domain.user.UserRepository;
import com.gm.tweak.exception.UserNotFoundException;

public class UserMemoryRepository implements UserRepository {

	private Map<String, User> users;

	public UserMemoryRepository() {
		users = new HashMap<String, User>();
	}

	@Override
	public User save(User user) {
		users.put(user.getId(), user);
		return user;
	}

	@Override
	public User findById(String id) throws Exception {
		User user = users.get(id);
		if (user == null) {
			throw new UserNotFoundException("USER NOT FOUND");
		}
		return user;
	}

	@Override
	public User findByEmail(String email) throws UserNotFoundException {
		for (User user : users.values()) {
			if (email.equals(user.getEmail())) {
				return user;
			}
		}
		throw new UserNotFoundException("USER NOT FOUND");
	}

	@Override
	public String getId() {
		return new String(UUID.randomUUID().toString());

	}
}
