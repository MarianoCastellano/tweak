package com.gm.tweak.domain.game;

public class PlayerGuessTheDrawingEvent implements DomainEvent {

	private PlayerDiviner player;
	private Game game;

	public PlayerGuessTheDrawingEvent(PlayerDiviner player, Game game) {
		this.player = player;
		this.game = game;
	}

	public PlayerDiviner getPlayerDiviner() {
		return player;
	}

	public Game getGame() {
		return game;
	}
}
