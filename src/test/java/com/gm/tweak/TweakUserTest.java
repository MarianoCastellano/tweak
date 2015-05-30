package com.gm.tweak;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.TweakUser;

public class TweakUserTest {

	@Test
	public void createTweakUser() {

		String email = "german@german.com";
		String username = "ger00";

		TweakUser tweakUser = new TweakUser(email, username);

		Assert.assertNotNull(tweakUser.getEmail());
		Assert.assertNotNull(tweakUser.getUsername());

		Assert.assertEquals(email, tweakUser.getEmail());
		Assert.assertEquals(username, tweakUser.getUsername());
	}

}
