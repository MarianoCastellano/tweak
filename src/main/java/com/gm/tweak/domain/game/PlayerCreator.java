package com.gm.tweak.domain.game;

public class PlayerCreator {

	private PlayerId playerId;
	private Long coins;

	public PlayerCreator(PlayerId playerId) {
		this.playerId = playerId;
		this.coins = new Long(10);
	}

	public void addCoins(Long coinsEarned) {
		this.coins += coinsEarned;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}
}