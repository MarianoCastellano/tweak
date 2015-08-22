package com.gm.tweak.helper;

import org.junit.Assert;

import com.gm.tweak.domain.user.User;

public class TestUtils {

	public static void assertUserIsValid(User user) {
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getId());
		Assert.assertNotNull(user.getEmail());
		Assert.assertNotNull(user.getUsername());
		Assert.assertNotNull(user.getPassword());
	}

}
