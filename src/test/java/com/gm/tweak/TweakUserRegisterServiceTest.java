package com.gm.tweak;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.repository.TweakUserTestRepository;
import com.gm.tweak.service.TweakUserRegisterService;

public class TweakUserRegisterServiceTest {

	private TweakUserRegisterService tweakUserRegisterService;

	@Test
	public void register() {

		tweakUserRegisterService = new TweakUserRegisterService(new TweakUserTestRepository());

		String email = "email";
		String username = "username";

		TweakUser tweakUser = tweakUserRegisterService.register(email, username);

		Assert.assertNotNull(tweakUser);
		Assert.assertEquals(email, tweakUser.getEmail());
		Assert.assertEquals(username, tweakUser.getUsername());
	}

}
