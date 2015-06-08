package com.gm.tweak;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gm.tweak.domain.User;
import com.gm.tweak.exception.ErrorCode;
import com.gm.tweak.exception.InvalidPasswordException;
import com.gm.tweak.exception.UserNotFoundException;
import com.gm.tweak.helper.TestUtils;
import com.gm.tweak.repository.UserMemoryRepository;
import com.gm.tweak.service.UserLoginService;
import com.gm.tweak.service.UserRegisterService;

public class UserLoginServiceTest {

	private UserLoginService userLoginService;
	private UserRegisterService userRegisterService;

	@Before
	public void init() {
		UserMemoryRepository userRepository = new UserMemoryRepository();
		userLoginService = new UserLoginService(userRepository);
		userRegisterService = new UserRegisterService(userRepository);
	}

	@Test
	public void successLogin() {
		User user = new User("1", "lala", "lala", "lala");
		userRegisterService.register(user.getEmail(), user.getUsername(), user.getPassword());

		User userFound = null;
		try {
			userFound = userLoginService.login(user.getEmail(), user.getPassword());
		} catch (UserNotFoundException | InvalidPasswordException e) {
			Assert.fail();
		}
		TestUtils.assertUserIsValid(userFound);

	}

	@Test
	public void failLogin() {

		try {
			try {
				userLoginService.login("ASDFG", "ASDFG");
			} catch (InvalidPasswordException e) {
				Assert.fail();
			}
		} catch (UserNotFoundException e) {
			Assert.assertTrue(e.getErrorCode() == ErrorCode.USER_NOT_FOUND);
		}

	}
}
