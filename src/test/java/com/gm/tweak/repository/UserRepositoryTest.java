package com.gm.tweak.repository;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.User;
import com.gm.tweak.helper.TestUtils;

public class UserRepositoryTest {

	private UserRepository userRepository = new UserMemoryRepository();

	@Test
	public void save() {

		User userToSave = new User("1", "lala", "lala", "lala");
		User savedUser = userRepository.save(userToSave);

		TestUtils.assertUserIsValid(savedUser);

		Assert.assertEquals(userToSave.getEmail(), savedUser.getEmail());
		Assert.assertEquals(userToSave.getUsername(), savedUser.getUsername());
		Assert.assertEquals(userToSave.getPassword(), savedUser.getPassword());
	}

	@Test
	public void findById() {

		User savedUser = new User("1", "lala", "lala", "lala");
		userRepository.save(savedUser);

		User foundUser = null;
		try {
			foundUser = userRepository.findById(savedUser.getId());
		} catch (Exception e) {
			Assert.fail();
		}

		TestUtils.assertUserIsValid(foundUser);

		Assert.assertEquals(savedUser.getEmail(), foundUser.getEmail());
		Assert.assertEquals(savedUser.getUsername(), foundUser.getUsername());
		Assert.assertEquals(savedUser.getPassword(), foundUser.getPassword());
	}
}
