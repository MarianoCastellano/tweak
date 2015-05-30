package com.gm.tweak;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.TweakUser;

public class TweakUserTest {

	@Test
	public void createTweakUser() {

		String email = "german@german.com";
		String username = "ger00";
		String password = "12345";

		TweakUser tweakUser = new TweakUser(email, username, password);

		Assert.assertNotNull(tweakUser.getEmail());
		Assert.assertNotNull(tweakUser.getUsername());
		Assert.assertNotNull(tweakUser.getPassword());

		Assert.assertEquals(email, tweakUser.getEmail());
		Assert.assertEquals(username, tweakUser.getUsername());
		Assert.assertEquals(password, tweakUser.getPassword());

	}

}
