package com.gm.tweak.domain.game.factory;

import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.PlayerId;

public class GameBuilder {

	private GameId gameId;
	private PlayerId playerIdCreator;
	private Drawing drawing;

	public GameBuilder withGameId(GameId gameId) {
		this.gameId = gameId;

		return this;
	}

	public GameBuilder withPlayerIdCreator(PlayerId playerIdCreator) {
		this.playerIdCreator = playerIdCreator;

		return this;
	}

	public GameBuilder withDrawing(Drawing drawing) {
		this.drawing = drawing;

		return this;
	}

	public Game build() {
		return new Game(gameId, playerIdCreator, drawing);
	}
}