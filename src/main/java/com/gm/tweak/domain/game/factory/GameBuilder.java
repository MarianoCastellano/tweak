package com.gm.tweak.domain.game.factory;

import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.user.event.AddAchievementsPlayerEvent;
import com.gm.tweak.domain.user.event.AddCoinPlayerEvent;
import com.gm.tweak.domain.user.event.AddStatsPlayerEvent;
import com.gm.tweak.domain.user.event.DomainEvent;
import com.gm.tweak.exception.GameCreationException;

public class GameBuilder {

	private GameId gameId;
	private Drawing drawing;
	private Player playerCreator;
	private DomainEvent domainEvent;

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

	public GameBuilder withDomainEvent(DomainEvent domainEvent) {
		this.domainEvent = domainEvent;
		this.domainEvent.attach(new AddCoinPlayerEvent());
		this.domainEvent.attach(new AddStatsPlayerEvent());
		this.domainEvent.attach(new AddAchievementsPlayerEvent());
		return this;
	}

	public Game build() throws GameCreationException {
		validate();
		Game game = new Game(gameId, drawing, playerCreator, domainEvent);
		return game;
	}

	private void validate() throws GameCreationException {
		if (ifGameContainsNullProperties()) {
			throw new GameCreationException("Cannot create game");
		}
		
	}

	private boolean ifGameContainsNullProperties() {
		return !(gameId!= null && drawing!= null && playerCreator!= null && domainEvent != null);
	}

}