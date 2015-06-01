package com.gm.tweak.test.game;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.game.PlayerId;
import com.gm.tweak.repository.GameMemoryRepository;
import com.gm.tweak.service.GameService;

public class GameTest {

	private GameService gameService;

	@Before
	public void init() {
		gameService = new GameService(new GameMemoryRepository());
	}

	@Test
	public void whenCreateAGameWithDrawingAndCreatorThenGameIsSaved() {
		Game game = createGame();

		Assert.assertNotNull(game.getGameId());
	}

	@Test
	public void whenGetAllGamesThenGetUniqueGameCreated() {
		createGame();

		List<Game> games = gameService.findAllGames();

		Assert.assertEquals(1, games.size());;
	}

	private Game createGame() {
		Drawing stone = new Drawing("Stone", new Byte[100]);
		Player playerCreator = new Player(new PlayerId("1"));

		return gameService.createGame(stone, playerCreator.getPlayerId());
	}
}