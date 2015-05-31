package com.gm.tweak.helper;

import org.junit.Assert;

import com.gm.tweak.domain.TweakUser;

public class TestUtils {

	public static TweakUser createDefaultTweakUser() {
		return new TweakUser("DEFAULT_EMAIL", "DEFAULT_USERNAME", "DEFAULT_PASSWORD");
	}

	public static void assertTweakuserIsValid(TweakUser tweakUser) {
		Assert.assertNotNull(tweakUser);
		Assert.assertNotNull(tweakUser.getId());
		Assert.assertNotNull(tweakUser.getEmail());
		Assert.assertNotNull(tweakUser.getUsername());
		Assert.assertNotNull(tweakUser.getPassword());
	}

}
