package com.gm.tweak.service;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.User;
import com.gm.tweak.helper.TestUtils;
import com.gm.tweak.repository.UserMemoryRepository;

public class UserRegisterServiceTest {

	private UserRegisterService userRegisterService;

	@Test
	public void register() {

		userRegisterService = new UserRegisterService(new UserMemoryRepository());

		String email = "email";
		String username = "username";
		String password = "12345";

		User user = userRegisterService.register(email, username, password);

		TestUtils.assertUserIsValid(user);

		Assert.assertEquals(email, user.getEmail());
		Assert.assertEquals(username, user.getUsername());
		Assert.assertEquals(password, user.getPassword());

	}

}
