package com.gm.tweak.domain.game;

public class Player {

	private PlayerId playerId;

	public Player(PlayerId playerId) {
		this.playerId = playerId;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}
}