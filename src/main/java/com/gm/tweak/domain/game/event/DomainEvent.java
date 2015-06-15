package com.gm.tweak.domain.game.event;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;

public interface DomainEvent {

	void attach(PlayerEvent playerEvent);

	void notifyEvents(Game game, Player diviner);
}