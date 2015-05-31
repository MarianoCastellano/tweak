package com.gm.tweak;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.helper.TestUtils;
import com.gm.tweak.repository.TweakUserRepository;
import com.gm.tweak.repository.TweakUserTestRepository;

public class TweakUserRepositoryTest {

	private TweakUserRepository tweakUserRepository = new TweakUserTestRepository();

	@Test
	public void save() {

		TweakUser tweakUserToSave = TestUtils.createDefaultTweakUser();

		TweakUser savedTweakUser = tweakUserRepository.save(tweakUserToSave);

		TestUtils.assertTweakuserIsValid(savedTweakUser);

		Assert.assertEquals(tweakUserToSave.getEmail(), savedTweakUser.getEmail());
		Assert.assertEquals(tweakUserToSave.getUsername(), savedTweakUser.getUsername());
		Assert.assertEquals(tweakUserToSave.getPassword(), savedTweakUser.getPassword());
	}

	@Test
	public void findById() {

		TweakUser savedTweakUser = tweakUserRepository.save(TestUtils.createDefaultTweakUser());

		TweakUser foundTweakUser = null;
		try {
			foundTweakUser = tweakUserRepository.findById(savedTweakUser.getId());
		} catch (Exception e) {
			Assert.fail();
		}

		TestUtils.assertTweakuserIsValid(foundTweakUser);

		Assert.assertEquals(savedTweakUser.getEmail(), foundTweakUser.getEmail());
		Assert.assertEquals(savedTweakUser.getUsername(), foundTweakUser.getUsername());
		Assert.assertEquals(savedTweakUser.getPassword(), foundTweakUser.getPassword());
	}
}
