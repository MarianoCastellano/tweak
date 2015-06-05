package com.gm.tweak.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.gm.tweak.domain.User;
import com.gm.tweak.exception.UserNotFoundException;

//TODO CR-NANO: Es para test? o es en memoria? =).
public class UserTestRepository implements UserRepository {

	private Map<Long, User> users;

	public UserTestRepository() {
		users = new HashMap<Long, User>();
	}

	@Override
	public User save(User user) {
		long id = UUID.randomUUID().getMostSignificantBits();
		user.assignId(id);
		users.put(id, user);
		return user;
	}

	@Override
	public User findById(Long id) throws Exception {
		User user = users.get(id);
		if (user == null) {
			// TODO CR-NANO: Lanzar la exception correcta. Abajo lo haces!
			throw new Exception("USER NOT FOUND");
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
}
