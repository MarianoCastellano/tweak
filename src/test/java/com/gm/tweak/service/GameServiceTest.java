package com.gm.tweak.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gm.tweak.domain.game.Board;
import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.PlayerId;
import com.gm.tweak.domain.game.Word;
import com.gm.tweak.repository.GameMemoryRepository;

public class GameServiceTest {

	private GameService gameService;

	@Before
	public void init() {
		gameService = new GameService(new GameMemoryRepository());
	}

	@Test
	public void saveGame() {
		Game game = gameService.create(new Drawing(new PlayerId("1"),
				new Board(new byte[1]), new Word("Stone")));
		List<Game> allGames = gameService.findAllGames();
		Assert.assertTrue(allGames.contains(game));
		Assert.assertEquals(1, allGames.size());

	}
}