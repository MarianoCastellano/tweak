package com.gm.tweak.service;

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
import com.gm.tweak.repository.GameMemoryRepository;

public class GameServiceTest {

	private GameService gameService;

	@Before
	public void init() {
		gameService = new GameService(new GameMemoryRepository());
	}

	@Test
	public void createGame() {
		PlayerId playerId = new PlayerId("1");
		Player player = new Player(playerId);

		Game game = gameService.create(new Drawing(playerId, new Board(
				new byte[1]), new Word("Stone")), player);
		List<Game> allGames = gameService.findAllGames();
		Assert.assertTrue(allGames.contains(game));
		Assert.assertEquals(1, allGames.size());

	}

	@Test
	public void playerWonTheGame() {
		PlayerId playerId = new PlayerId("1");
		Player player = new Player(playerId);

		Game game = gameService.create(new Drawing(playerId, new Board(
				new byte[1]), new Word("Stone")), player);

		gameService.tryWord(game.getGameId(), new Player(new PlayerId("2")),
				new Word("Stone"));

		Long coins = game.getGameCreator().getCoins();
		Assert.assertEquals(new Long(31), coins);
	}

	@Test
	public void drawingIncrementsPrice() {
		PlayerId playerId = new PlayerId("1");
		Player player = new Player(playerId);

		Game game = gameService.create(new Drawing(playerId, new Board(
				new byte[1]), new Word("Stone")), player);

		gameService.tryWord(game.getGameId(), new Player(new PlayerId("2")),
				new Word("Asdas"));
		gameService.tryWord(game.getGameId(), new Player(new PlayerId("2")),
				new Word("Magada"));

		Price drawingPrice = game.getDrawing().getPrice();
		Assert.assertEquals(new Price(new Long(3)), drawingPrice);

	}
}