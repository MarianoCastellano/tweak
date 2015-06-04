package com.gm.tweak.test.game;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.PlayerCreator;
import com.gm.tweak.domain.game.PlayerDiviner;
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
	public void handleEventsTest() {

		Game game = createGame();
		PlayerDiviner diviner = new PlayerDiviner(new PlayerId("2"));

		diviner.tryWord("Stone", game);
		diviner.tryWord("ARBOL", game);

		List<String> triedWords = diviner.getTriedWords();

		game.handleEvents();

		Assert.assertEquals(2L, triedWords.size());
		Assert.assertEquals(2L, triedWords.size());
		Assert.assertEquals(new Long(11), diviner.getCoins());

	}

	@Test
	public void whenGetAllGamesThenGetUniqueGameCreated() {
		createGame();

		List<Game> games = gameService.findAllGames();

		Assert.assertEquals(1, games.size());
	}

	private Game createGame() {
		Drawing stone = new Drawing("Stone", new Byte[100]);
		PlayerCreator playerCreator = new PlayerCreator(new PlayerId("1"));

		return gameService.createGame(stone, playerCreator.getPlayerId());
	}
}