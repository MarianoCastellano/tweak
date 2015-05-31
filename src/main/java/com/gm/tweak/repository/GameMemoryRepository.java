package com.gm.tweak.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;

public class GameMemoryRepository implements GameRepository {

	private Map<String, Game> games = new HashMap<String, Game>();

	@Override
	public void save(Game game) {
		this.games.put(game.getGameId().getId(), game);
	}

	@Override
	public GameId nextGameId() {
		String random = UUID.randomUUID().toString().toUpperCase();
		return new GameId(random.substring(0, random.indexOf("-")));
	}

	@Override
	public List<Game> findAll() {
		return new ArrayList<Game>(this.games.values());
	}
}