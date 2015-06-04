package com.gm.tweak.domain.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private GameId gameId;
	private PlayerId playerIdCreator;
	private Drawing drawing;
	private List<DomainEventHandler> eventHandlers = new ArrayList<DomainEventHandler>();

	public Game(GameId gameId, PlayerId playerId, Drawing drawing) {
		this.gameId = gameId;
		this.playerIdCreator = playerId;
		this.drawing = drawing;
	}

	public GameId getGameId() {
		return gameId;
	}

	public PlayerId getPlayerIdCreator() {
		return playerIdCreator;
	}

	public Drawing getDrawing() {
		return drawing;
	}

	@Override
	public boolean equals(final Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;

		final Game other = (Game) object;
		return other != null && gameId.equals(other.gameId);
	}

	@Override
	public int hashCode() {
		return gameId.hashCode();
	}
}