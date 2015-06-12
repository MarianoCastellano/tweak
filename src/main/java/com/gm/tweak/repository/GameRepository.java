package com.gm.tweak.repository;

import java.util.List;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;

public interface GameRepository {

	void save(Game game);

	GameId nextGameId();

	List<Game> findAll();

	Game findById(GameId gameId);

}