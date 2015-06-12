package com.gm.tweak.domain.game;

import java.util.ArrayList;
import java.util.List;

public class DomainEvent {

	private List<PlayerEvent> events;

	public DomainEvent() {
		events = new ArrayList<PlayerEvent>();
	}

	public void add(PlayerWonDomainEvent playerWonDomainEvent) {
		events.add(playerWonDomainEvent);
	}

}
