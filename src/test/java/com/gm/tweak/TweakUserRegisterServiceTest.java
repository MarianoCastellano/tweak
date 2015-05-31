package com.gm.tweak;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.helper.TestUtils;
import com.gm.tweak.repository.TweakUserTestRepository;
import com.gm.tweak.service.TweakUserRegisterService;

public class TweakUserRegisterServiceTest {

	private TweakUserRegisterService tweakUserRegisterService;

	@Test
	public void register() {

		tweakUserRegisterService = new TweakUserRegisterService(new TweakUserTestRepository());

		String email = "email";
		String username = "username";
		String password = "12345";

		TweakUser tweakUser = tweakUserRegisterService.register(email, username, password);

		TestUtils.assertTweakuserIsValid(tweakUser);

		Assert.assertEquals(email, tweakUser.getEmail());
		Assert.assertEquals(username, tweakUser.getUsername());
		Assert.assertEquals(password, tweakUser.getPassword());

	}

}
