package com.gm.tweak;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.helper.TestUtils;
import com.gm.tweak.repository.TweakUserTestRepository;
import com.gm.tweak.service.TweakUserLoginService;
import com.gm.tweak.service.TweakUserRegisterService;

public class TweakUserLoginServiceTest {

	private TweakUserLoginService tweakUserLoginService;
	private TweakUserRegisterService tweakUserRegisterService;

	@Before
	public void init() {
		TweakUserTestRepository tweakUserRepository = new TweakUserTestRepository();
		tweakUserLoginService = new TweakUserLoginService(tweakUserRepository);
		tweakUserRegisterService = new TweakUserRegisterService(tweakUserRepository);
	}

	@Test
	public void successLogin() {
		TweakUser tweakUser = TestUtils.createDefaultTweakUser();
		tweakUserRegisterService.register(tweakUser.getEmail(), tweakUser.getUsername(), tweakUser.getPassword());

		try {
			TweakUser foundTweakUser = tweakUserLoginService.login(tweakUser.getEmail(), tweakUser.getPassword());
			TestUtils.assertTweakuserIsValid(foundTweakUser);
		} catch (Exception e) {
			Assert.fail();
		}

	}

	@Test
	public void failLogin() {

		try {
			tweakUserLoginService.login("ASDFG", "ASDFG");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains("NOT FOUND"));
		}

	}
}
