package com.gm.tweak;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.exception.ErrorCode;
import com.gm.tweak.exception.InvalidPasswordException;
import com.gm.tweak.exception.UserNotFoundException;
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

		TweakUser foundTweakUser = null;
		try {
			foundTweakUser = tweakUserLoginService.login(tweakUser.getEmail(), tweakUser.getPassword());
		} catch (UserNotFoundException | InvalidPasswordException e) {
			Assert.fail();
		}
		TestUtils.assertTweakuserIsValid(foundTweakUser);

	}

	@Test
	public void failLogin() {

		try {
			try {
				tweakUserLoginService.login("ASDFG", "ASDFG");
			} catch (InvalidPasswordException e) {
				Assert.fail();
			}
		} catch (UserNotFoundException e) {
			Assert.assertTrue(e.getErrorCode() == ErrorCode.USER_NOT_FOUND);
		}

	}
}
