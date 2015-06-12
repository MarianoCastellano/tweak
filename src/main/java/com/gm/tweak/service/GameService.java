package com.gm.tweak.service;

import java.util.List;

import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.game.PlayerEvent;
import com.gm.tweak.domain.game.Word;
import com.gm.tweak.domain.game.factory.GameBuilder;
import com.gm.tweak.repository.GameRepository;

public class GameService {

	private GameRepository gameRepository;

	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public Game create(Drawing drawing,Player gameCreator) {
		GameId gameId = gameRepository.nextGameId();

		Game game = new GameBuilder().withGameId(gameId).withDrawing(drawing).withPlayerCreator(gameCreator).build();

		gameRepository.save(game);

		return game;
	}

	public void tryWord(GameId gameId, Player diviner, Word word) {
		Game game = gameRepository.findById(gameId);
		Boolean playerWon = game.tryWord(diviner, word);
		if (playerWon) {
			this.handle(game);
		}
	}

	private void handle(Game game) {

		for (PlayerEvent event : game.getDomainEvents()) {
			Long coinsReward = game.getDrawing().getPrice().getValue();
			event.getPlayer().addCoins(coinsReward);
			game.getGameCreator().addCoins(coinsReward);
		}
	}

	public List<Game> findAllGames() {
		return gameRepository.findAll();
	}

}