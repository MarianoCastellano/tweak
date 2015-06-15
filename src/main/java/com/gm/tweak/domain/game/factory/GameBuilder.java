package com.gm.tweak.domain.game.factory;

import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.Player;

public class GameBuilder {

	private GameId gameId;
	private Drawing drawing;
	private Player playerCreator;

	public GameBuilder withGameId(GameId gameId) {
		this.gameId = gameId;
		return this;
	}

	public GameBuilder withPlayerCreator(Player playerCreator) {
		this.playerCreator = playerCreator;
		return this;
	}

	public GameBuilder withDrawing(Drawing drawing) {
		this.drawing = drawing;
		return this;
	}

	public Game build() {
		return new Game(gameId, drawing,playerCreator);
	}

}