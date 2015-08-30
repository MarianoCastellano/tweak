package com.gm.tweak.application.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gm.tweak.domain.game.Board;
import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.game.PlayerId;
import com.gm.tweak.domain.game.Price;
import com.gm.tweak.domain.game.Word;
import com.gm.tweak.domain.user.PlayerStats;
import com.gm.tweak.exception.GameCreationException;
import com.gm.tweak.infrastructure.repository.GameMemoryRepository;

public class GameServiceTest {

	private GameService gameService;

	@Before
	public void init() {
		gameService = new GameService(new GameMemoryRepository());
	}

	@Test
	public void createGame() throws GameCreationException {

		PlayerId playerId = new PlayerId("1");
		Player player = new Player(playerId, new PlayerStats(0L, 0L, 0L));

		Game game = gameService.create(new Drawing(playerId, new Board(new byte[1]), new Word("Stone")),
				player);

		List<Game> allGames = gameService.findAllGames();

		Assert.assertTrue(allGames.contains(game));
		Assert.assertEquals(1, allGames.size());

	}

	@Test
	public void playerWonTheGame() throws GameCreationException {
		PlayerId playerId = new PlayerId("1");
		Player player = new Player(playerId, new PlayerStats(0L, 0L, 0L));

		Game game = gameService.create(new Drawing(playerId, new Board(new byte[1]), new Word("Stone")),
				player);

		gameService.tryWord(game.getGameId(), new Player(new PlayerId("2"), new PlayerStats(0L, 0L, 0L)),
				new Word("Stone"));

		Double coins = game.getPlayerCreator().getCoins();
		Assert.assertEquals(new Long(31), coins, 0.1);
	}

	@Test
	public void drawingIncrementsPrice() throws GameCreationException {
		PlayerId playerId = new PlayerId("1");
		Player player = new Player(playerId, new PlayerStats(0L, 0L, 0L));

		Game game = gameService.create(new Drawing(playerId, new Board(new byte[1]), new Word("Stone")),
				player);

		gameService.tryWord(game.getGameId(), new Player(new PlayerId("2"), new PlayerStats(0L, 0L, 0L)),
				new Word("Asdas"));
		gameService.tryWord(game.getGameId(), new Player(new PlayerId("2"), new PlayerStats(0L, 0L, 0L)),
				new Word("Magada"));

		Price drawingPrice = game.getDrawing().getPrice();
		Assert.assertEquals(new Price(new Double(3)), drawingPrice);
	}
}