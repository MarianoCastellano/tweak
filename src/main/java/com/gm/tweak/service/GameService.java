package com.gm.tweak.service;

import java.util.List;

import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.factory.GameBuilder;
import com.gm.tweak.repository.GameRepository;

public class GameService {

	private GameRepository gameRepository;

	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public Game create(Drawing drawing) {
		GameId gameId = gameRepository.nextGameId();

		Game game = new GameBuilder().withGameId(gameId).withDrawing(drawing)
				.build();

		gameRepository.save(game);

		return game;
	}

	public List<Game> findAllGames() {
		return gameRepository.findAll();
	}

}