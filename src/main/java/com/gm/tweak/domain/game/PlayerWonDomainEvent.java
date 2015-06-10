package com.gm.tweak.domain.game;

public class PlayerWonDomainEvent {

	private Player diviner;

	public PlayerWonDomainEvent(Player diviner) {
		this.diviner = diviner;
	}

	public Player getDiviner() {
		return diviner;
	}
}
