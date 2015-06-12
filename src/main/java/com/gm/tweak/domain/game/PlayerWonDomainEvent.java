package com.gm.tweak.domain.game;

public class PlayerWonDomainEvent implements PlayerEvent {

	private Player player;

	public PlayerWonDomainEvent(Player player) {
		this.player = player;
	}

	@Override
	public Player getPlayer() {
		return player;
	}
}
