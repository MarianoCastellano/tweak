package com.gm.tweak.domain.user.event;

import java.util.ArrayList;
import java.util.List;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;

public class PlayerWonDomainEvent implements DomainEvent {

	private List<PlayerEvent> events = new ArrayList<PlayerEvent>();

	@Override
	public void attach(PlayerEvent playerEvent) {
		this.events.add(playerEvent);
	}

	@Override
	public void notifyEvents(Game game, Player diviner) {
		for (PlayerEvent playerEvent : events) {
			playerEvent.update(game, diviner);
		}
	}

}
