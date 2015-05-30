package com.gm.tweak;

import org.junit.Assert;
import org.junit.Test;

import com.gm.tweak.domain.TweakUser;
import com.gm.tweak.repository.TweakUserRepository;

public class TweakUserRepositoryTest {

	private TweakUserRepository tweakUserRepository = new TweakUserTestRepository();

	@Test
	public void save() {

		String userEmail = "userEmail";
		String userUsername = "userUsername";

		TweakUser tweakUserToSave = new TweakUser(userEmail, userUsername);

		TweakUser savedTweakUser = tweakUserRepository.save(tweakUserToSave);

		Assert.assertNotNull(savedTweakUser);
		Assert.assertNotNull(savedTweakUser.getId());
		Assert.assertNotNull(savedTweakUser.getEmail());
		Assert.assertNotNull(savedTweakUser.getUsername());

		Assert.assertEquals(tweakUserToSave.getEmail(), savedTweakUser.getEmail());
		Assert.assertEquals(tweakUserToSave.getUsername(), savedTweakUser.getUsername());
	}

	@Test
	public void findById() {

		String userEmail = "userEmail";
		String userUsername = "userUsername";

		TweakUser savedTweakUser = tweakUserRepository.save(new TweakUser(userEmail, userUsername));

		TweakUser foundTweakUser = tweakUserRepository.findById(savedTweakUser.getId());

		Assert.assertNotNull(foundTweakUser);
		Assert.assertNotNull(foundTweakUser.getId());
		Assert.assertNotNull(foundTweakUser.getEmail());
		Assert.assertNotNull(foundTweakUser.getUsername());

		Assert.assertEquals(savedTweakUser.getEmail(), foundTweakUser.getEmail());
		Assert.assertEquals(savedTweakUser.getUsername(), foundTweakUser.getUsername());
	}
}
