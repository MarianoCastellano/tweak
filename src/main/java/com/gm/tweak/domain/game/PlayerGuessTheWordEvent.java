package com.gm.tweak.domain.game;

public class PlayerGuessTheWordEvent implements DomainEventHandler {

	private PlayerCreator player;

	public PlayerGuessTheWordEvent(PlayerCreator player) {
		this.player = player;
	}

	public PlayerCreator getPlayer() {
		return player;
	}

}
